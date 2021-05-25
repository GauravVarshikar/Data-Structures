package HashTables;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringChar {
    public static void main(String[] args) {
        //Google Question
        //Given array: [1,2,3,4,5,1,2,3]
        //It should return 1

        //Given array: [1,2,3,4,5,4,2,3]
        //It should return 4

        //Given array: [1,2,3,4,5]
        //It should return null

        int[] nums = new int[]{1,2,3,4,5,1,2,3};
        System.out.println(findFirstRecurringChar(nums));

        nums = new int[]{1,2,3,4,5,4,2,3};
        System.out.println(findFirstRecurringChar(nums));

        nums = new int[]{1,2,3,4,5};
        System.out.println(findFirstRecurringChar(nums));

        nums = new int[]{1};
        System.out.println(findFirstRecurringChar(nums));
    }

    private static Integer findFirstRecurringChar(int[] nums) {
        if(nums.length<2){
            return null;
        }
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            if (numSet.contains(num)) {
                return num;
            } else {
                numSet.add(num);
            }
        }
        return null;
    }
}
