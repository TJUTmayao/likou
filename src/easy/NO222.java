package easy;

/**
 * @ClassName NO222
 * @Description 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/19 15:05
 */
public class NO222 {
    public static void main(String[] args) {
        NO222 no222 = new NO222();
        int[] ints = no222.diStringMatch("DDI");
        System.out.println();
    }
    public int[] diStringMatch(String S) {
//        int N = S.length();
//        int left = 0,right = N;
//        int[] ints = new int[N + 1];
//        for (int i = N - 1; i >= 0; i--) {
//            if (S.charAt(i) == 'I'){
//                ints[i + 1] = right --;
//            }else {
//                ints[i + 1] = left ++;
//            }
//        }
//        ints[0] = left;
//        return ints;
        int N = S.length();
        int left = 0,right = N;
        int[] ints = new int[N + 1];
        for (int i = 0; i < N; i ++) {
            if (S.charAt(i) == 'I'){
                ints[i] = left ++;
            }else {
                ints[i] = right --;
            }
        }
        ints[N] = left;
        return ints;
    }
}
