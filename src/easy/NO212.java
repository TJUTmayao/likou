package easy;

/**
 * @ClassName NO212
 * @Description 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 *
 * 在此过程之后，我们得到一些数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/13 16:11
 */
public class NO212 {
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE,min = A[0];
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]){
                max = A[i];
            }else {
                if (min > A[i]) {
                    min = A[i];
                }
            }
        }
        int res = max - min - 2 * K;
        if (res <= 0){
            return 0;
        }
        return res;
    }
}
