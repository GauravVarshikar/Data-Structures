package Array;

public class MaxSubArraySum {

    public static void main(String[] args) {
        /*
        Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
        Example 1:
        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
        Example 2:
        Input: nums = [1]
        Output: 1
        Example 3:
        Input: nums = [5,4,-1,7,8]
        Output: 23
        Constraints:
        1 <= nums.length <= 3 * 104
        -105 <= nums[i] <= 105
        Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
        which is more subtle.
         */

        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(findMaxSum(arr));

    }

    private static int findMaxSum(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        int maxSum = arr[0];
        int tempSum = arr[0];
        for(int i=1; i<arr.length; i++){
            tempSum = Math.max(arr[i], tempSum + arr[i]);
            maxSum = Math.max(tempSum, maxSum);
        }
        return maxSum;
    }
}
