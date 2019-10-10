package easy;

/**
 * @ClassName NO211
 * @Description 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 * @Author 11432
 * @DATE 2019/9/13 16:06
 */
public class NO211 {
    public int[] sortArrayByParity(int[] A) {
        // 指针j永远指向一个下标最小的奇数，同时也是偶数子数组的末尾
        for (int i = 0,j = 0; i < A.length; i++) {
            if (A[i] % 2 == 0){
                int x = A[j];
                A[j] = A[i];
                A[i] = x;
                j ++;
            }
        }
        return A;
    }
}
