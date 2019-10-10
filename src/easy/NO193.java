package easy;

/**
 * @ClassName NO193
 * @Description 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 *
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-squares-in-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/2 16:21
 */
public class NO193 {
    public static void main(String[] args) {
        NO193 no193 = new NO193();
        System.out.println(no193.numMagicSquaresInside(new int[][]{
                {8,1,6},{3,5,7},{4,9,2}}));
    }
    /**方格元素之和为 45，等于 1 到 9 的元素和。
     每行每列的和最多为 15，因为三条这样的平行线等于整个方格之和。
     对角线之和也为 15，由问题的定义可知。
     将经过中心点的 4 条线所包含的 12 个值相加，和为 60；但总和也等于 45 加上三倍的中间值，这意味着中间点的值是 5。*/
    public int numMagicSquaresInside(int[][] grid) {
        int num = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (isSame(grid,i,j) && grid[i][j] == 5){
                    int  k = grid[i - 1][j - 1] + grid[i + 1][j + 1];
                    if (k != 10 || k != grid[i + 1][j - 1] + grid[i - 1][j + 1]){continue;}
                    if (k != grid[i - 1][j] + grid[i + 1][j]){continue;}
                    if (k != grid[i][j - 1] + grid[i][j + 1]){continue;}
                    num++;
                }
            }
        }
        return num;
    }
    public boolean isSame(int[][] grid,int x,int y){
        int[] ints = new int[10];
        for (int i = -1; i <= 1; i++) {
            int sum = 0;
            int sum2 = 0;
            for (int j = -1; j <= 1 ; j++) {
                int k = grid[x + i][y + j];
                sum += k;
                sum2 += grid[x + j][y + i];
                if (k > 9 || k == 0 || ints[k] != 0){
                    return false;
                }
                ints[k]++;
            }
            if(sum != 15 || sum2 != 15){return false;}
        }
        return true;
    }
}
