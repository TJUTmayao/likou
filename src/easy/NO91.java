package easy;

/**
 * @ClassName NO91
 * @Description 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *              请注意，你可以假定字符串里不包括任何不可打印的字符。
 * @Author 11432
 * @DATE 2019/7/27 15:34
 */
public class NO91 {
    public int countSegments(String s) {
        if (s == null || "".equals(s)){
            return 0;
        }
        int count = 0;
        for (int i = 0,j = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(j) != ' '){
                count ++;
            }
            j = i;
        }
        return s.charAt(s.length() - 1) == ' ' ? count : count + 1;
    }
}
