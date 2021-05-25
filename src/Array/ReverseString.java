package Array;

public class ReverseString {

    public static void main(String[] args){
        String arr = "Hi My name is Gaurav!";
        System.out.println("input: " + arr);
        StringBuilder result = new StringBuilder();
        for(int i=arr.length()-1; i>=0;i--){
            result.append(arr.charAt(i));
        }
        System.out.println("output : " + result);
        System.out.println("Time Complexity : O(n)");
        System.out.println("Space Complexity : O(n)");
    }

}
