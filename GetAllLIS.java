import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Vector;

/**
 *  Get All Longest Increasing Subsequences (LIS)
 *  Time Complexity - O(n*m + m^2).
 */
public class GetAllLIS {

    private int[] arr;

    public GetAllLIS(int[] arr) {
        this.arr = arr;
    }

    static class IncreasingSubsequence {
        int longest;
        int index;
        int value;
        String subsequence;

        IncreasingSubsequence(int l, int i, int v, String s) {
            this.longest = l;
            this.index = i;
            this.value = v;
            this.subsequence = s;
        }
    }

    /**
     * Time Complexity - O(n*m + m^2)
     * @return all possible LIS contains in a 2D numeric array.
     */
    public int[][] allLIS() {
        if(this.arr.length == 0) {
            return new int[][]{{}};
        }

        int length = arr.length;
        int[] dp = new int[length];

        int longest = 0;
        for(int i = 0; i < length; i++) { // O(N^2)
            int max = 0;

            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            if(dp[i] > longest) {
                longest = dp[i];
            }
        } // end for

        //an ArrayDeque allows us to add or remove an element from both sides
        ArrayDeque<GetAllLIS.IncreasingSubsequence> arrayDeque = new ArrayDeque<>();

        for(int i = 0; i < dp.length; i++) { // O(n)
            if(longest == dp[i]) {
                arrayDeque.add(new GetAllLIS.IncreasingSubsequence(longest, i, arr[i], "" + arr[i])); // normal add
            }
        }

        Vector<String> vector = new Vector<>();
        while(!arrayDeque.isEmpty()) { // O(n*m)
            GetAllLIS.IncreasingSubsequence removed = arrayDeque.removeFirst();

            if(removed.longest == 1) {
                vector.add(removed.subsequence);
            }

            for(int i = removed.index - 1; i >= 0; i--) {
                if(dp[i] == removed.longest - 1 && arr[i] < removed.value) {
                    arrayDeque.add(new GetAllLIS.IncreasingSubsequence(dp[i], i, arr[i], arr[i] + " " + removed.subsequence));
                }
            }
        }// end while

        // split the strings and parse to integer and into an array.
        int[][] allLIS = new int[vector.size()][longest];
        for(int i = 0; i < vector.size(); i++) { // O(m*m)
            String str = vector.get(i);
            String str_to_lis = "";
            int[] lis = new int[longest];
            int k = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == ' ') {
                    lis[k] = Integer.parseInt(str_to_lis);
                    str_to_lis = "";
                    k++;
                } else if(j == str.length()-1) {
                    str_to_lis += str.charAt(j);
                    lis[k] = Integer.parseInt(str_to_lis);
                }
                else {
                    str_to_lis += str.charAt(j);
                }
            }
            allLIS[i] = lis;
        }
        return allLIS;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        GetAllLIS lis = new GetAllLIS(new int[] {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10});
        int[][] allLIS = lis.allLIS();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("All LIS : ");
        for(int[] sub : allLIS){
            System.out.println(Arrays.toString(sub));
        }
        System.out.println("Time: " + time + "ms.");
    }

}


