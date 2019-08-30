package easy;

/**
 * @ClassName NO177
 * @Description 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 *
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 *
 * 如果矩阵存储在磁盘上，并且磁盘内存是有限的，因此一次最多只能将一行矩阵加载到内存中，该怎么办？
 * 如果矩阵太大以至于只能一次将部分行加载到内存中，该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/29 15:47
 */
public class NO177 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            if (!isOk(matrix[i],matrix[i + 1])){
                return false;
            }
        }
        return true;
    }
    public boolean isOk(int[] a,int[] b){
        for (int i = 0,j = 1; i < a.length - 1; i++,j++) {
            if (a[i] != b[j]){
                return false;
            }
        }
        return true;
    }


}
