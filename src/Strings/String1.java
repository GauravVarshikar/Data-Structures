package Strings;

public class String1 {
    public static void main(String[] args) {
        String s = "hello";
        int[] arr = new int[26];

        for(char c: s.toCharArray()) {
            arr[c - 'a']++;
        }

        for(int n: arr){
            System.out.print(n + " ");
        }
    }
}
