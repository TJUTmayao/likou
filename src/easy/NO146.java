package easy;

/**
 * @ClassName NO146
 * @Description 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/image-smoother
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/16 15:35
 */
public class NO146 {
    /** 暴力法 */
    public int[][] imageSmoother(int[][] M) {
        int sum = 0;
        int[][] ints = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                int count = 0;
                sum = 0;
                for (int k = i - 1 >= 0 ? i - 1 : 0; k <= i + 1 && k < M.length; k++) {
                    for (int l = j - 1 >= 0 ? j - 1 : 0; l <= j + 1 && l < M[k].length; l++) {
                        sum += M[k][l];
                        count ++;
                    }
                }
                ints[i][j] = sum / count;
            }
        }
        return ints;
    }

    public int[][] imageSmoother2(int[][] M) {
        int sum = 0;
        int count = 0;
        int[][] ints = new int[M.length][M[0].length];
        // 头一个
        for (int k = 0; k <= 1 && k < M.length; k++) {
            for (int l = 0; l <= 1 && l < M[k].length; l++) {
                sum += M[k][l];
                count ++;
            }
        }
        ints[0][0] = sum / count;
        // 头一行
        for (int i = 0; i < M[0].length; i++) {
            if (i > 0){
                for (int j = 0; j <= 1 && j < M.length; j++) {

                }
            }
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                count = 0;
                sum = 0;
                ints[i][j] = sum / count;
            }
        }
        return ints;
    }

}
