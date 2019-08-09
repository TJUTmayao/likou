package easy;

/**
 * @ClassName NO115
 * @Description 给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 *
 * @Author 11432
 * @DATE 2019/8/7 16:40
 */
public class NO115 {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("ffffffffF"));
    }
    public static boolean detectCapitalUse(String word) {
        int num = 0;
        boolean isStart = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 91){
                isStart = i < 1;
                num ++;
            }else {
                if (!isStart){
                    return false;
                }
            }
        }
        return (num <= 1 && isStart) || num == word.length();
    }
}
