package easy;

/**
 * @ClassName NO204
 * @Description 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 *
 * 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
 *
 * 投影就像影子，将三维形体映射到一个二维平面上。
 *
 * 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
 *
 * 返回所有三个投影的总面积。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/projection-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/9 14:31
 */
public class NO204 {
    public int projectionArea(int[][] grid) {
        // 总面积
        int total = 0;
        int length = grid[0].length;
        int positiveMax;
        int sideMax;
        for (int i = 0; i < grid.length; i++) {
            positiveMax = 0;
            sideMax = 0;
            for (int j = 0; j < length; j++) {
                if (grid[i][j] != 0){
                    total ++;
                    positiveMax = Math.max(positiveMax,grid[i][j]);
                }
                sideMax = Math.max(sideMax,grid[j][i]);
            }
            total += positiveMax + sideMax;
        }
        return total;
    }
}
