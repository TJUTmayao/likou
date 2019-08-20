package easy;

/**
 * @ClassName NO151
 * @Description 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @Author 11432
 * @DATE 2019/8/17 15:54
 */
public class NO151 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
    }
    /** 递归版 */
    public static boolean validPalindrome(String s) {
        return digui(s.toCharArray(),0,s.length() - 1,0,1);
    }
    public static boolean digui(char[] chars,int i,int j,int num,int max){
        if (i >= j){
            return true;
        }
        if (chars[i] != chars[j]){
            num++;
            if (num > max){
                return false;
            }
            return digui(chars,i + 1,j,num,max) || digui(chars,i,j - 1,num,max);
        }else {
            return digui(chars,i + 1,j - 1,num,max);
        }
    }

    /** 非递归版 */
    public static boolean validPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int x = -1,y = -1;
        int num = 0;
        for (int i = 0,j = chars.length - 1; i <= j;) {
            if (chars[i] != chars[j]){
                if (x == -1){
                    num++;
                    x = i;y = j;
                    i ++;
                }else {
                    i = x;j = y;
                    x = -1;y = -1;
                    j--;
                }
                if (num > 1){
                    return false;
                }
            }else {
                i++;
                j--;
            }
        }
        return true;
    }

}
