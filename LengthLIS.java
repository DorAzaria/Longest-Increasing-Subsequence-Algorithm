import java.util.Arrays;

/**
 * Length of Longest Increasing Subsequence (LIS).
 * Time Complexity - O(nlogn).
 */
public class LengthLIS {

    private int[] arr;

    public LengthLIS(int[] arr) {
        this.arr = arr;
    }

    /**
     * Time Complexity - O(nlogn)
     * @return a length of LIS (int)
     */
    public int lengthLIS() {
        if(this.arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        int len = 0;
        for (int num : arr) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        LengthLIS lis = new LengthLIS(new int[] {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10});
        int length = lis.lengthLIS();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Length : " + length);
        System.out.println("Time: " + time + "ms.");
    }
}
