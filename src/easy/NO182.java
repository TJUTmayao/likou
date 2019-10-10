package easy;

/**
 * @ClassName NO182
 * @Description 给定两个字符串, A 和 B。
 *
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 
 * 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/30 16:49
 */
public class NO182 {
    public static void main(String[] args) {
        NO182 no182 = new NO182();
        System.out.println(no182.rotateString("abcde","abced"));
    }
    public boolean rotateString(String A, String B) {
        if (A.length() == B.length() && A.length() == 0){
            return true;
        }
        if (A.length() != B.length()){
            return false;
        }
        for (int i = B.length() - 1; i >= 0; i--) {
            int j = 0;
            int x = i;
            while (j < A.length() && A.charAt(j) == B.charAt(x)){
                x = (x + 1) % A.length();
                j ++;
            }
            if (j >= A.length()){
                return true;
            }
        }
        return false;
    }
}
