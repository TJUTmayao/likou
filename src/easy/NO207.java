package easy;

/**
 * @ClassName NO207
 * @Description 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/9 16:38
 */
public class NO207 {
    public static void main(String[] args) {
        NO207 no207 = new NO207();
        System.out.println(no207.surfaceArea(new int[][]{{1,2},{3,4}}));
    }
    public int surfaceArea(int[][] grid) {
        int length = grid[0].length;
        int total = 0;
        int k;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] > 0){
                    total += (grid[i][j] << 2) + 2;
                    k = i - 1;
                    if (i > 0 && grid[k][j] > 0){
                        total -= (Math.min(grid[i][j],grid[k][j]) << 1);
                    }
                    k = j - 1;
                    if (j > 0 && grid[i][k] > 0){
                        total -= (Math.min(grid[i][j],grid[i][k]) << 1);
                    }
                }
            }
        }
        return total;
    }
}
