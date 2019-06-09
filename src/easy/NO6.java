package easy;

import java.util.Stack;

/**
 * @ClassName NO6
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/8 17:23
 */
public class NO6 {

    public static void main(String[] args) {
        System.out.println(isRight("()"));
    }

    public static boolean isRight(String s){
        char[] stack = new char[s.length()];
        int size = 0;
        if (s.length() == 0){
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (size > 0 && getOther(stack[size - 1]) == c){
                size --;
            }else {
                stack[size ++] = c;
            }
        }
        return size == 0;
    }

    private static char getOther(char c){
        switch (c){
            case '(':
                return ')';
            case '[':
                return ']';
                default:
                    return '}';
        }
    }
}
