package easy;

/**
 * @ClassName NO209
 * @Description 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotonic-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/13 15:28
 */
public class NO209 {
    public boolean isMonotonic(int[] A) {
        boolean sub = false;
        int k = 1;
        for (int i = 0,j = 1; i < A.length - 1; i++,j++) {
            if (A[j] == A[i]){
                k ++;
                continue;
            }
            if (A[j] > A[i]){
                if (!sub && i >= k){
                    return false;
                }
                sub = true;
            }
            else if (A[j] < A[i]){
                if (sub && i >= k){
                    return false;
                }
            }
        }
        return true;
    }
}
