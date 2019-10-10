package easy;

import java.util.Arrays;

/**
 * @ClassName NO258
 * @Description： <p> 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，
 * 然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 *
 * 以这种方式修改数组后，返回数组可能的最大和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 </p>
 * @Author mayao
 * @Date 2019/10/7 15:13
 */
public class NO258 {
    public static void main(String[] args) {
        largestSumAfterKNegations3(new int[]{4,-5,4,-5,9,4,5},1);
    }
    public static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int num = 0;
        for (int i = 0; i < A.length;) {
            int m = i;
            if (K > 0){
                if (A[i] < 0){
                    A[i] = -A[i];
                    K --;
                }else {
                    if (i > 0 && A[i - 1] < A[i]){
                        i = i - 1;
                        m -= 1;
                        if (K % 2 != 0){
                            num -= A[i];
                            A[i] = -A[i];
                        }
                    }else {
                        if (K % 2 != 0){
                            A[i] = -A[i];
                        }
                    }
                    K--;
                }
            }
            num += A[i];
            i = m + 1;
        }
        return num;
    }

    public static int largestSumAfterKNegations2(int[] A, int K) {
        Arrays.sort(A);
        int num = 0;
        int i;
        for (i = 0; K > 0 && i < A.length && A[i] < 0; i++) {
            A[i] = -A[i];
            num += A[i];
            K --;
        }
        if (i > 0 && A[i - 1] < A[i]){
            i --;
            num -= A[i];
        }
        if (K % 2 != 0){
            A[i] = -A[i];
        }
        for (; i < A.length; i++) {
            num += A[i];
        }
        return num;
    }


    /** 给定范围可以使用 bitmap 排序 */
    public static int largestSumAfterKNegations3(int[] A, int K) {
        int[] ints = new int[201];
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            ints[A[i] + 100] ++;
        }
        for (int i = 0; i < ints.length && K > 0; i++) {
            if (ints[i] != 0){
                if (i < 100){
                    while (ints[i] > 0 && K > 0){
                        ints[i] --;
                        ints[200 - i] ++;
                        K--;
                    }
                }else {
                    if (K % 2 != 0){
                        ints[i] --;
                        ints[200 - i] ++;
                        K = 0;
                    }
                }
            }
        }
        for (int i = 0; i < ints.length; i++) {
            while (ints[i]-- > 0){
                num += i - 100;
            }
        }
        return num;
    }
}
