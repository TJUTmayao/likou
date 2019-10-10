package easy;

/**
 * @ClassName NO191
 * @Description 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/2 15:39
 */
public class NO191 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0,k = A[i].length - 1; j <= k; j++,k--) {
                if (A[i][j] == A[i][k]){
                    int n = A[i][j] == 0 ? 1 : 0;
                    A[i][j] = n;
                    A[i][k] = n;
                }
            }
        }
        return A;
    }
}
