/**
 * Number of Longest Increasing Subsequence (LIS)
 * Using Segment Tree.
 * Time Complexity - O(n*logn).
 */
public class NumberOfLIS_Optimal {

    private int[] arr;

    public NumberOfLIS_Optimal(int[] arr){
        this.arr = arr;
    }

    public int numOfLIS() {
        if(this.arr.length == 0) {
            return 0;
        }

        /* find min and max in arr */
        int min = arr[0];
        int max = arr[0];
        for(int i = 0 ; i < arr.length; i++) { // O(n)
            if(min > arr[i]) { min = arr[i]; }
            if(max < arr[i]) { max = arr[i]; }
        }

        Range root = new Range(min, max);

        /* for each number in arr, which represents the range below this number,
         * we're getting the RangeData: (number and length of LIS).
         * then we'll update the tree (insert) with the new data and updates the root
         * in case we get data with longer LIS. */
        for(int i = 0 ; i < arr.length; i++) { // O(nlogn)
            RangeData d = query(root, arr[i]-1); // O(logn)
            insert(root, arr[i], new RangeData(d.numberOfLIS, d.lengthOfLIS + 1)); // O(logn)
        }
        return root.data.numberOfLIS;
    }

    /**
     * This method will tell us the range data of the range specified by the given 'range'
     * When 'key' is outside the range specified by 'range', we return the answer.
     * Otherwise, we'll divide the range into two and query both ranges, then merge the result.
     * @param range range specified by the given 'Range' object.
     * @param key int
     * @return RangeData
     */
    public RangeData query(Range range, int key) { // O(logn)
        if(range.rightCorner <= key) {
            return range.data;
        }
        else if(range.leftCorner > key) {
            return new RangeData(1, 0);
        }
        else {
            RangeData left = query(range.leftHalf(), key);
            RangeData right = query(range.rightHalf(), key);
            return merge(left, right);
        }
    }

    /**
     * This iterative method is making the decision of which range
     * of the two, has the longest increasing subsequence.
     * For example, if r1=(num:2,len:3) and r2=(num:1,len=3),
     * then we'll return a new RangeData of (num:3,len:3).
     * @param r1 RangeData (contains length and number of LIS)
     * @param r2 RangeData (contains length and number of LIS)
     * @return the RangeData with the longest LIS.
     */
    public RangeData merge(RangeData r1, RangeData r2) { // O(1)
        if(r1.lengthOfLIS == r2.lengthOfLIS) {

            if(r1.lengthOfLIS == 0) {
                return new RangeData(1, 0);
            }

            return new RangeData(r1.numberOfLIS + r2.numberOfLIS, r1.lengthOfLIS);
        }

        if(r1.lengthOfLIS > r2.lengthOfLIS) {
            return r1;
        }
        return r2;
    }

    /**
     * We repeatedly insert the key into the correct half of the range that
     * 'range' specifies, and after such insertion this range's
     * data could change, so we merge the range data together again.
     * @param range a Range object.
     * @param key insert the key into the correct half of the range.
     * @param data RangeData (contains length and number of LIS)
     */
    public void insert(Range range, int key, RangeData data) { // O(logn)
        if(range.leftCorner == range.rightCorner) {
            range.data = merge(range.data, data);
            return;
        }
        else if(key <= range.middle()) {
            insert(range.leftHalf(), key, data);
        }
        else {
            insert(range.rightHalf(), key, data);
        }
        // after such insertion this range's data could change,
        // so we merge the data of the ranges together again.
        range.data = merge(range.leftHalf().data, range.rightHalf().data);
    }

    /* Contains the left and right corner values.
     * those values are not always represents the values in arr.
     * leftHalf and rightHalf are Range objects. */
    static class Range {
        int leftCorner, rightCorner;
        Range leftHalf, rightHalf;
        RangeData data;
        public Range(int start, int end) {
            this.leftCorner = start;
            this.rightCorner = end;
            leftHalf = null;
            rightHalf = null;
            data = new RangeData(1, 0);
        }
        public int middle() {
            return leftCorner + (rightCorner - leftCorner) / 2;
        }
        public Range leftHalf() {
            if (leftHalf == null)
                leftHalf = new Range(leftCorner, middle());
            return leftHalf;
        }
        public Range rightHalf() {
            if (rightHalf == null)
                rightHalf = new Range(middle() + 1, rightCorner);
            return rightHalf;
        }
    }

    /* Contains the number of LIS and the length
     * of this subsequence in a specific range. */
    static class RangeData {
        int numberOfLIS;
        int lengthOfLIS;
        public RangeData(int numLIS, int lenLIS) {
            this.numberOfLIS = numLIS;
            this.lengthOfLIS = lenLIS;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        NumberOfLIS_Optimal lis = new NumberOfLIS_Optimal(new int[] {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10});
        int num = lis.numOfLIS();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Number of LIS : " + num);
        System.out.println("Time: " + time + "ms.");
    }

}
