package easy;

import java.util.Stack;

/**
 * @ClassName NO33
 * @Description 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *              说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @Author 11432
 * @DATE 2019/7/9 13:11
 */
public class NO33 {

    public static void main(String[] args) {
        NO33 no33 = new NO33();
        System.out.println(no33.isPalindrome("race a car"));
    }

    private static final int CHA = 'a' - 'A';

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i ,j;
        for (i =0,j = chars.length - 1; i < j;){
           int check1 = check(chars[i]);
           while (check1 == -1 && i < j){
               i ++;
               check1 = check(chars[i]);
           }
           if (i == j){
               return true;
           }
           int check2 = check(chars[j]);
           while (check2 == -1 && j > i){
               j --;
               check2 = check(chars[j]);
           }
           if (check1 != check2){
               return false;
           }else {
               if (compare(chars[i],chars[j],check1)){
                   i ++;
                   j --;
               }else {
                   return false;
               }
           }
       }
       return true;
    }

    public int check(char c){
        if (c >= '0' && c <= '9'){
            return 1;
        }
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
            return 2;
        }
        return -1;
    }

    public boolean compare(char c1,char c2,int i){
        switch (i){
            case 1:
                return c1 == c2;
            case 2:
                return Math.abs(c1 - c2) == CHA || c1 == c2;
        }
        return false;
    }
}
