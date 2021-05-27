package Stacks;

import java.util.Arrays;

public class StackArray {
    private Integer[] stack = new Integer[20];
    int length;
    private Integer top; private Integer bottom;

    public void push(int val){
        if(length == 0){
            top = bottom = val;
        } else {
            top = val;
        }
        stack[length++] = val;
    }
    public Integer peek(){
        return stack[length-1];
    }
    public Integer pop() {
        if(length == 0) {
            top = null;
            bottom = null;
            return null;
        } else {
            Integer retInt = top;
            stack[length-1] = null;
            if(length-1 == 0) {
                top = null;
            } else {
                top = stack[length - 2];
            }
            length--;
            return retInt;
        }
    }

    @Override
    public String toString() {
        return "StackArray{" +
                "stack=" + Arrays.toString(stack) +
                ", length=" + length +
                ", top=" + top +
                ", bottom=" + bottom +
                '}';
    }
}
