package easy;

/**
 * @ClassName NO157
 * @Description 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-binary-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/21 15:24
 */
public class NO157 {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }
    public static int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        int x,y;
        x = 1;
        y = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]){
                x ++;
            }else {
                num += Math.min(x,y);
                y = x;
                x = 1;
            }
        }
        num += Math.min(x,y);
        return num;
    }
}
