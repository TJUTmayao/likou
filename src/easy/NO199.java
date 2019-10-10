package easy;

/**
 * @ClassName NO199
 * @Description 给定一个矩阵 A， 返回 A 的转置矩阵。
 *
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * @Author 11432
 * @DATE 2019/9/6 14:52
 */
public class NO199 {
    public int[][] transpose(int[][] A) {
        int X = A[0].length;
        int Y = A.length;
        int[][] ints = new int[X][Y];
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                ints[j][i] = A[i][j];
            }
        }
        return ints;
    }
}
