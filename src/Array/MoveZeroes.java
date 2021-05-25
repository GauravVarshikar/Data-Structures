package Array;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        /*
        Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
        Note that you must do this in-place without making a copy of the array.
        Example 1:
        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]
        Example 2:
        Input: nums = [0]
        Output: [0]
         */
        int[] arr = new int[]{0,1,0,3,12};
        System.out.println(Arrays.toString(moveZeroes(arr)));

        int[] arr1 = new int[]{0};
        System.out.println(Arrays.toString(moveZeroes(arr1)));
    }

    private static int[] moveZeroes(int[] arr) {
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] == 0 && arr[j] !=0) {
                    arr[i] = arr[j];
                    arr[j] = 0;
                    break;
                }
            }
        }
        return arr;
    }
}
