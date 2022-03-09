package HashTables;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayEqualsZerosAndOnes {
    public static void main(String[] args) {
        int[] arr = {0,1,1,1,0};
        int[] arr2 = {1,1,1,1};
        int[] arr3 = {1,1,0,1,0,1,0,0,1,1};
        int[] arr4 = {1,0,1};
        int[] arr5 = {1,1,1,0,0};
        System.out.println(longestSubArrayWithEqualZerosAndOnes(arr));
        System.out.println(longestSubArrayWithEqualZerosAndOnes(arr2));
        System.out.println(longestSubArrayWithEqualZerosAndOnes(arr3));
        System.out.println(longestSubArrayWithEqualZerosAndOnes(arr4));
        System.out.println(longestSubArrayWithEqualZerosAndOnes(arr5));
    }

    private static int longestSubArrayWithEqualZerosAndOnes(int[] arr) {
        //{0 ,1, 1, 1, 0}
        int res = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        int preSum = 0;
        //replace all 0s with -1
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0) {
                arr[i] = -1;
            }
        }
        //After above loop {-1 ,1, 1, 1, -1}
        //check the longest subarray with sum equal to zero
        for(int i=0; i<arr.length; i++){
            preSum += arr[i];//-1,0,1,2,1
            if(preSum==0) res = i+1;//2
            if(sumMap.containsKey(preSum)){
                res = Math.max(res, i-sumMap.get(preSum));
            } else {
                sumMap.put(preSum, i);
                //{-1,0},{0,1},{1,2},{2,3}
            }
        }
        return res;
    }
}
