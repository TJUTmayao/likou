package easy;

/**
 * @ClassName NO14
 * @Description 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * @Author 11432
 * @DATE 2019/6/23 8:35
 */
public class NO14 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World   "));
    }

    public static int lengthOfLastWord(String s) {
        if (s.length() == 0){
            return 0;
        }
        int count = 0;
        int i;
        for (i = s.length() - 1; i >= 0 && s.charAt(i) == ' '; i--) { }
        for (; i >= 0 && s.charAt(i) != ' '; i--) {
            count ++;
        }
        return count;
    }
}
