package HashTables;

import java.util.HashSet;
import java.util.Set;

public class PrefixSubArraySum {

    public static void main(String[] args) {
        int[] arr = {-3, 4 , -3, -1, 1};
        int[] arr2 = {-3, 1 , -2, -1, 1};
        int[] arr3 = {-3, 2, 1};
        int[] arr4 = {1 ,21, 2, 3, 0, -4, -2, 1};
        int[] arr5 = {1 ,21, 2, 3, 10, -4, -2, 1};

        //function to check if there is a sub array with sum equal to 0
        System.out.println(subArrayWithFixSumExists(arr, 0));
        System.out.println(subArrayWithFixSumExists(arr2, 3));
        System.out.println(subArrayWithFixSumExists(arr3, 3));
        System.out.println(subArrayWithFixSumExists(arr4, 26));
        System.out.println(subArrayWithFixSumExists(arr5, 9));
    }

    private static boolean subArrayWithFixSumExists(int[] arr, int fixSum) {
        Set<Integer> preSumSet = new HashSet<>();
        int preSum = 0;
        for(int i: arr){
            preSum += i;
            if(preSum == fixSum) return true;
            if(preSumSet.contains(preSum - fixSum)){
                return true;
            }

            preSumSet.add(preSum);
        }
        return false;
    }
}
