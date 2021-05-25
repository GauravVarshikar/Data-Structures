package Array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        /*
        Given an array, rotate the array to the right by k steps, where k is non-negative.
        Example 1: Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4]
        Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]

        Example 2: Input: nums = [-1,-100,3,99], k = 2
        Output: [3,99,-1,-100]
        Explanation:
        rotate 1 steps to the right: [99,-1,-100,3]
        rotate 2 steps to the right: [3,99,-1,-100]
        */
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        System.out.println(Arrays.toString(rotateArray(arr,k%arr.length)));
        rotateArrayInPlace(arr, k);

        arr = new int[]{-1,-100,3,99};
        k = 2;
        System.out.println(Arrays.toString(rotateArray(arr,k)));
    }

    private static int[] rotateArray(int[] arr, int k) {
        int[] result = new int[arr.length];
        int j=0;
        if(arr.length < 2){
            return null;
        }
        k %= arr.length;
        for(int i=arr.length-k; i<arr.length; i++){
            result[j++] = arr[i];
        }
        for(int i=0; i<arr.length-k; i++){
            result[j++] = arr[i];
        }
        return result;
    }

    private static void rotateArrayInPlace(int[] arr, int k){
        for(int count=0; count<k%arr.length; count++){
            for(int i=arr.length-1; i>0; i--){
                int temp = arr[i-1];
                arr[i-1]=arr[i];
                arr[i] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
