package easy;

/**
 * @ClassName NO120
 * @Description 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，
 * 并将剩余的字符保持原样。
 * @Author 11432
 * @DATE 2019/8/9 16:27
 */
public class NO120 {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg",2));
    }
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int towK = k * 2;
        char x;
        int n;
        for (int j = 0; j < length; j += towK) {
            n = j + k - 1 > length - 1 ? length - 1 : j + k - 1;
            for (int l = j; l < n; l++,n--) {
                x = chars[l];
                chars[l] = chars[n];
                chars[n] = x;
            }
        }
        return new String(chars);
    }
}
