// 287. Find the Duplicate Number

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

    public static void main(String args[]) {
        int arr[] ={1,3,4,2,2};
        System.out.println("Duplicate value is : "+usingHashSet(arr));
    }
}