package easy;

/**
 * @ClassName NO86
 * @Description 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *              在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *              假设字符串的长度不会超过 1010。
 * @Author 11432
 * @DATE 2019/7/26 10:31
 */
public class NO86 {
    public static void main(String[] args) {
        NO86 no86 = new NO86();
        System.out.println(no86.longestPalindrome("bb"));
    }
    private boolean haveOne = false;
    public int longestPalindrome(String s) {
        int[] letter = new int[128];
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i)] ++;
        }
        int length = 0;
        for (int i = 0; i < letter.length; i++) {
            length += letter[i] - (letter[i] & 1);
        }
        return length < s.length() ? length + 1 : length;
    }
}
