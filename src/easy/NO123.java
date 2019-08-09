package easy;

/**
 * @ClassName NO123
 * @Description 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * @Author 11432
 * @DATE 2019/8/9 17:53
 */
public class NO123 {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
    public static String reverseWords(String s) {
        char c;
        char[] chars = s.toCharArray();
        for (int i = 0,j = 0; i < chars.length ;) {
            if (j < chars.length && chars[j] != ' '){
                j++;
            }else {
                for (int k = i,n = j - 1; k < n; k++,n--) {
                    c = chars[k];
                    chars[k] = chars[n];
                    chars[n] = c;
                }
                j ++;
                i = j;
            }
        }
        return new String(chars);
    }
}
