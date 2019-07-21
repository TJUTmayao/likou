package easy;

/**
 * @ClassName NO81
 * @Description 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 * @Author 11432
 * @DATE 2019/7/21 18:24
 */
public class NO81 {
    public char findTheDifference(String s, String t) {
        int[] zifu = new int[26];
        for (int i = 0; i < s.length(); i++) {
            zifu[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0,j; i < t.length(); i++) {
            j = t.charAt(i) - 'a';
            zifu[j] -= 1;
            if (zifu[j] < 0){
                return t.charAt(i);
            }
        }
        return ' ';
    }

    /** 数学 */
    public char findTheDifference2(String s, String t) {
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            x = x - s.charAt(i) + t.charAt(i);
        }
        x += t.charAt(t.length() - 1);
        return (char) x;
    }

    /** 位运算，可以用异或代替 */
    public char findTheDifference3(String s, String t) {
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            x = x ^ s.charAt(i) ^ t.charAt(i);
        }
        x ^= t.charAt(t.length() - 1);
        return (char) x;
    }
}
