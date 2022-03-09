package HashTables;

import java.util.HashSet;
import java.util.Set;

public class PrefixSumZero {
    public static void main(String[] args) {
        int[] arr = {-3, 4 , -3, -1, 1};
        int[] arr2 = {-3, 1 , -2, -1, 1};
        int[] arr3 = {-3, 2, 1};
        int[] arr4 = {1 ,21, 2, 3, 0, -4, -2, 1};
        int[] arr5 = {1 ,21, 2, 3, 10, -4, -2, 1};

        //function to check if there is a sub array with sum equal to 0
        System.out.println(subArrayWithSumZeroExists(arr));
        System.out.println(subArrayWithSumZeroExists(arr2));
        System.out.println(subArrayWithSumZeroExists(arr3));
        System.out.println(subArrayWithSumZeroExists(arr4));
        System.out.println(subArrayWithSumZeroExists(arr5));
    }

    private static boolean subArrayWithSumZeroExists(int[] arr) {
        //idea is to store sum of numbers in a hashset
        //if the new sum value already exists in the hashset then the result is true
        Set<Integer> prefixSumSet = new HashSet<>();
        int preSum = 0;

        for(int i: arr){
            preSum += i;
            if (prefixSumSet.contains(preSum)) return true;
            if(preSum == 0) return true;
            prefixSumSet.add(preSum); //-3, -2,
        }
        return false;
    }
}
