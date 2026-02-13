// 287. Find the Duplicate Number
// https://leetcode.com/problems/find-the-duplicate-number/description/?utm=codolio
import java.util.HashSet;

public class J01DuplicateNumber {
    // Approach 1:- Using HashSet
    public static int usingHashSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    // Approach 2: Negative Marking (if modifying array is allowed)
    public static int usingNegativeMarking(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]);
            if (arr[index] < 0) {
                return index;
            }
            arr[index] = -arr[index];
        }
        return -1;
    }

    // Approach 3: Floyd's Cycle Detection (Most Optimal)
    public static int usingFloydCycle(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Find the entrance to the cycle
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, 4, 2, 2 };
        System.out.println("Duplicate value is : " + usingHashSet(arr));

        int arr2[] = { 3, 1, 3, 4, 2 };
        System.out.println("Duplicate value is : " + usingNegativeMarking(arr2));

        int arr3[] = { 1, 3, 4, 2, 2 };
        System.out.println("Duplicate value is : " + usingFloydCycle(arr3));
    }
}