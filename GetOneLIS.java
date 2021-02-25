import java.util.ArrayList;
import java.util.Arrays;

/**
 * Get one Longest Increasing Subsequence (LIS).
 * Time Complexity - O(n^2).
 */
public class GetOneLIS {

    private int[] arr;

    GetOneLIS(int[] arr) {
        this.arr = arr;
    }

    public int[] getOneLIS() {
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

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        GetOneLIS lis = new GetOneLIS(new int[] {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10});
        int[] oneLIS = lis.getOneLIS();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("LIS in a numeric array : " + Arrays.toString(oneLIS));
        System.out.println("Time: " + time + "ms.");
    }
}
