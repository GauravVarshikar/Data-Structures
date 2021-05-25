package Array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        /*
        Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
        Example 1: Input: nums = [1,2,3,1]
        Output: true
        Example 2: Input: nums = [1,2,3,4]
        Output: false
        Example 3: Input: nums = [1,1,1,3,3,4,3,2,4,2]
        Output: true
         */
        int[] arr = new int[]{1,2,3,1};
        System.out.println(containsDuplicate(arr));
        int[] arr2 = new int[]{1,2,3,4};
        System.out.println(containsDuplicate(arr2));
        int[] arr3 = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(arr3));
    }

    private static boolean containsDuplicate(int[] arr) {
        Set<Integer> items = new HashSet<>();
        for (int value : arr) {
            if (items.contains(value)) {
                return true;
            } else {
                items.add(value);
            }
        }
        return false;
    }
}
