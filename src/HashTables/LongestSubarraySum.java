package HashTables;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySum {

    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 5, -6, 6, 2, 2};
        int[] arr2 = {-3, 1 , -2, -1, 1};
        int[] arr3 = {-3, 2, 1};
        int[] arr4 = {1 ,21, 2, 3, 0, -4, -2, 1};
        int[] arr5 = {1 ,21, 2, 3, 10, -4, -2, 1};
        System.out.println(longestSubArrayWithFixSum(arr, 4));
        System.out.println(longestSubArrayWithFixSum(arr2, 3));
        System.out.println(longestSubArrayWithFixSum(arr3, 3));
        System.out.println(longestSubArrayWithFixSum(arr4, 26));
        System.out.println(longestSubArrayWithFixSum(arr5, 9));
    }

    private static int longestSubArrayWithFixSum(int[] arr, int fixSum) {
        //{8, 3, 1, 5, -6, 6, 2, 2} ==> 4
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int preSum = 0;
        int res = 0;
        for(int i=0; i<arr.length; i++){ //8, 3, 1, 5,-6,6,2,2
            preSum += arr[i]; //8, 11, 12, 17,11,17,19,21
            if(preSum == fixSum) res = i+1;
            if(!preSumMap.containsKey(preSum)) {
                preSumMap.put(preSum, i);
                //{8,0},{11,1},{12,2},{17,3},{19,6},{21,7}
            }
            if(preSumMap.containsKey(preSum-fixSum)){
                res = Math.max(res, i-preSumMap.get(preSum-fixSum));// 2, 4
            }
        }
        return res;
    }
}
