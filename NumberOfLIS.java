/**
 * Number of Longest Increasing Subsequence (LIS).
 * Time Complexity - O(n^2).
 */
public class NumberOfLIS {

    private int[] arr;

    public NumberOfLIS(int[] arr) {
        this.arr = arr;
    }

    /**
     * Time Complexity - O(n^2)
     * @return the number of LIS (int)
     */
    public int numOfLIS() {
        if(arr.length == 0) {
            return 0;
        }

        int[] numbers = new int[arr.length];
        int[] lengths = new int[arr.length];
        int count_lis = 0;
        int longest = 0;

        for(int i = 0 ; i < arr.length; i++) { // O(n)
            numbers[i] = 1;
            lengths[i] = 1;
        }

        for(int i = 0; i < arr.length; i++) { // O(n^2)
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    if(lengths[i] < lengths[j] + 1) {
                        numbers[i] = numbers[j];
                        lengths[i] = lengths[j] + 1;
                    }
                    else if(lengths[i] == lengths[j] + 1) {
                        numbers[i] += numbers[j];
                    }
                }
            } // end inner for
            if(longest < lengths[i]) {
                count_lis = numbers[i];
                longest = lengths[i];
            }
            else if(longest == lengths[i]) {
                count_lis += numbers[i];
            }
        } // end main for
        return count_lis;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        NumberOfLIS lis = new NumberOfLIS(new int[] {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10});
        int num = lis.numOfLIS();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Number of LIS : " + num);
        System.out.println("Time: " + time + "ms.");
    }
}
