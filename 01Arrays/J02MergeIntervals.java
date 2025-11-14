// 56. Merge Intervals

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J02MergeIntervals {

    // Approach -1  --> Some testcases not passed
    public static int[][] usingArray(int[][] intervals) {
        int max = intervals[0][0];
        // Traverse the matrix to find maximum element
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                if (intervals[i][j] > max) {
                    max = intervals[i][j];
                }
            }
        }

        // Initilize the array to find frequency
        int[] freq = new int[max + 1];

        // Mark the frequency
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int j = start; j < end; j++) {
                freq[j] = 1;
            }
        }

        // Calculate the final merged frequency
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                int start = i;
                int end = i;
                while (i < freq.length && freq[i] == 1) {
                    end = i;
                    i++;
                }
                result.add(new int[] { start, end + 1 });
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String args[]) {
        int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        int[][] result = usingArray(arr);
        System.out.println(Arrays.deepToString(result));

        int[][] arr2 = { { 1, 4 }, { 5, 6 } };
        System.out.println(Arrays.deepToString(usingArray(arr2)));
    }
}
