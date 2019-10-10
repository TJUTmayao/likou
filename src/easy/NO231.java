package easy;

/**
 * @ClassName NO231
 * @Description 给出一个整数数组 A 和一个查询数组 queries。
 *
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 *
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 *
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/23 16:42
 */
public class NO231 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0){
                sum += A[i];
            }
        }
        int[] ints = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (A[queries[i][1]] % 2 == 0){
                if (queries[i][0] % 2 == 0){
                    sum += queries[i][0];
                }else {
                    sum -= A[queries[i][1]];
                }
                ints[i] = sum;
            }else {
                if (queries[i][0] % 2 != 0){
                    sum += queries[i][0] + A[queries[i][1]];
                }
                ints[i] = sum;
            }
            A[queries[i][1]] = queries[i][0] + A[queries[i][1]];
        }
        return ints;
    }
}
