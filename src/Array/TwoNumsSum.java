package Array;

import java.util.*;

public class TwoNumsSum {

    public static void main(String[] args) {
        /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
        Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Output: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:
        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:
        Input: nums = [3,3], target = 6
        Output: [0,1]
         */

        System.out.println("IN QUADRATIC TIME O(n^2)");
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(findTwoNumsQuadratic(nums, target)));

        int[] nums2 = new int[] {3,2,4};
        int target2 = 6;
        System.out.println(Arrays.toString(findTwoNumsQuadratic(nums2, target2)));

        int[] nums3 = new int[] {3,3};
        int target3 = 6;
        System.out.println(Arrays.toString(findTwoNumsQuadratic(nums3, target3)));

        System.out.println("IN LINEAR TIME O(n)");
        System.out.println(Arrays.toString(findTwoNumsLinear(nums, target)));
        System.out.println(Arrays.toString(findTwoNumsLinear(nums2, target2)));
        System.out.println(Arrays.toString(findTwoNumsLinear(nums3, target2)));
    }

    private static int[] findTwoNumsQuadratic(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length < 2) {
            return null;
        }
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    private static int[] findTwoNumsLinear(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length < 2) {
            return null;
        }

        Map<Integer, Integer> numMap = new HashMap<>();
        //Store numbers in a HashMap with key as the number and value as the index
        for(int i=0; i<nums.length; i++){
            numMap.put(nums[i], i);
        }

        //iterate through the array one item at a time and lookup for the complement (target-self) in the Map
        for(int i=0; i<nums.length; i++){
            int complement = target-nums[i];
            if(numMap.containsKey(complement) && i != numMap.get(complement)){
                result[0] = i;
                result[1] = numMap.get(complement);
                break;
            }
        }
        return result;
    }
}
