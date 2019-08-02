package easy;

/**
 * @ClassName NO102
 * @Description 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * @Author 11432
 * @DATE 2019/8/2 18:04
 */
public class NO102 {
    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{
                {0,1,0,0},
            {1,1,1,0},
            {0,1,0,0},
            {1,1,0,0}
        }));
    }
    public static int islandPerimeter(int[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1){
                    num += 4;
                    if (j != 0){
                        if (grid[i][j - 1] == 1){
                            num -= 2;
                        }
                    }
                    if (i != 0){
                        if (grid[i - 1][j] == 1){
                            num -= 2;
                        }
                    }
                }
            }
        }
        return num;
    }
}
