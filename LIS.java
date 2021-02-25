import java.util.*;

public class LIS {

    /*****************************************************************
     *****************************************************************
     * Question 1 - Constructor **************************************
     *****************************************************************
     *****************************************************************/
    private int[] arr;
    private int teta;
    private boolean isQ3;
    private int numsLIS;

    public LIS(int[] arr, int teta) {
        this.arr = arr;
        this.teta = teta;
        this.isQ3 = false;
        this.numsLIS = 0;
    }

    public int getTeta() {
        return this.teta;
    }
    /*****************************************************************
     *****************************************************************
     *****************************************************************
     *****************************************************************
     * Question 2 - length of LIS ************************************
     *****************************************************************
     *****************************************************************
     *****************************************************************
     *****************************************************************/

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

    /*****************************************************************
     *****************************************************************
     *****************************************************************
     *****************************************************************
     * Question 3 - number of all LIS ********************************
     *****************************************************************
     *****************************************************************
     *****************************************************************
     *****************************************************************/

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
        this.isQ3 = true;
        this.numsLIS = count_lis;
        return count_lis;
    }

    /*****************************************************************
     *****************************************************************
     *****************************************************************
     *****************************************************************
     * Question 4 - return all LIS in numeric array ******************
     *****************************************************************
     *****************************************************************
     *****************************************************************
     *****************************************************************/

    public int[][] allLIS() {
        if(this.arr.length == 0) {
            return new int[][]{{}};
        }
        if(this.isQ3 && this.numsLIS > this.teta){
            return new int[][] {returnOneLIS()};
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
        ArrayDeque<IncreasingSubsequence> arrayDeque = new ArrayDeque<>();

        for(int i = 0; i < dp.length; i++) { // O(n)
            if(longest == dp[i]) {
                arrayDeque.add(new IncreasingSubsequence(longest, i, arr[i], "" + arr[i])); // normal add
            }
        }

        Vector<String> vector = new Vector<>();
        while(!arrayDeque.isEmpty()) { // O(n^2)
            IncreasingSubsequence removed = arrayDeque.removeFirst();

            if(removed.longest == 1) {
                vector.add(removed.subsequence);
            }

            for(int i = removed.index - 1; i >= 0; i--) {
                if(dp[i] == removed.longest - 1 && arr[i] < removed.value) {
                    arrayDeque.add(new IncreasingSubsequence(dp[i], i, arr[i], arr[i] + " " + removed.subsequence));
                }
            }
        }// end while

        // split the strings and parse to integer and into an array.
        int[][] allLIS = new int[vector.size()][longest];
        for(int i = 0; i < vector.size(); i++) { // O(n^2)
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
            if(vector.size() > this.teta) {
                break;
            }
        }
        return allLIS;
    }

    private int[] returnOneLIS() {
        ArrayList<ArrayList<Integer>> sequence = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            sequence.add(new ArrayList<>());
        }

        sequence.get(0).add(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && sequence.get(j).size() > sequence.get(i).size()) {
                    sequence.set(i, new ArrayList<>(sequence.get(j)));
                }
            }

            sequence.get(i).add(arr[i]);
        }

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sequence.get(j).size() < sequence.get(i).size()) {
                j = i;
            }
        }

        ArrayList<Integer> listLIS = sequence.get(j);

        int[] oneLIS = new int[listLIS.size()];
        for(int i = 0 ; i < oneLIS.length; i++) {
            oneLIS[i] = listLIS.get(i);
        }
        return oneLIS;
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
}