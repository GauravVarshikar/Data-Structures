package Array;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        //Merge 2 sorted arrays [1,5,8,9] , [2,4,6,10] => [1,2,4,5,6,8,9,10]
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{5, 6 ,7, 8};
        System.out.println(Arrays.toString(mergeArrays(arr1, arr2)));

        int[] arr3 = new int[]{};
        int[] arr4 = new int[]{5, 6 ,7, 8};
        System.out.println(Arrays.toString(mergeArrays(arr3, arr4)));
    }

    private static int[] mergeArrays(int[] a1, int[] a2){
        int[] result = new int[a1.length + a2.length];
        if(a1.length == 0 && a2.length == 0){
            return null;
        }
        int i=0; int j=0; int k=0;
        while(i < a1.length && j <a2.length){
            if(a1[i] <= a2[j]) {
                result[k++] = a1[i++];
            } else {
                result[k++] = a2[j++];
            }
        }
        if(i == a1.length){
            while (j<a2.length){
                result[k++] = a2[j++];
            }
        }
        else if (j == a2.length){
            while (i < a1.length){
                result[k++] = a1[i++];
            }
        }
        return result;
    }
}
