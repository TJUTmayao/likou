package easy;

/**
 * @ClassName NO214
 * @Description 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转
 * @Author 11432
 * @DATE 2019/9/13 17:13
 */
public class NO214 {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        for (int i = 0,j = chars.length - 1; i < j;) {
            while (!isCase(chars[i])){
                i++;
            }
            while (!isCase(chars[j])){
                j--;
            }
            if (i < j){
                char c = chars[i];
                chars[i] = chars[j];
                chars[j] = c;
                i++;
                j--;
            }
        }
        return new String(chars);
    }
    public boolean isCase(char c){
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
}
