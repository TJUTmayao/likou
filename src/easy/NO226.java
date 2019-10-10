package easy;

/**
 * @ClassName NO226
 * @Description 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 * @Author 11432
 * @DATE 2019/9/21 18:43
 */
public class NO226 {
    public int repeatedNTimes(int[] A) {
        int[] ints = new int[10000];
        int N = A.length >> 1;
        for (int i = 0; i < A.length; i++) {
            ints[A[i]] ++;
            if (ints[A[i]] == N){
                return A[i];
            }
        }
        return -1;
    }
    /** 巧解: 题目要求有N+1种不同的元素，则除去答案其他所有元素都不相同，此时只有两种可能
     * 1、答案与其他元素交替，如：2,3,4,3 此时答案必定在两边。
     * 2、答案与其他元素不交替，如：2,3,3,4,或 3,2,4,3，此时答案要么在两边，要么两个答案（目标元素）相邻。
     * */
    public int repeatedNTimes2(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]){
                return A[i];
            }
        }
        return A[0] == A[2] ? A[0] : A[A.length - 1];
    }
}
