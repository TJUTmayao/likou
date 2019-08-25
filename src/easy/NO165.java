package easy;

/**
 * @ClassName NO165
 * @Description 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，
 *                 并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * @Author 11432
 * @DATE 2019/8/23 16:51
 */
public class NO165 {
    public static void main(String[] args) {
        System.out.println(new NO165().toLowerCase("AAA"));
    }
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 90 && chars[i] >= 65){
                chars[i] += 32;
            }
        }
        return new String(chars);
    }
}
