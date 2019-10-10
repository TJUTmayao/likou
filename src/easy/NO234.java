package easy;

import other.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NO234
 * @Description 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/24 16:21
 */
public class NO234 {
    public static void main(String[] args) {
        NO234 no234 = new NO234();
        System.out.println(no234.orangesRotting(new int[][]{
                {1}
        }));
    }
    public int orangesRotting(int[][] grid) {
        int[] addX = new int[]{-1,0,1,0};
        int[] addY = new int[]{0,1,0,-1};
        int time = 0;
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int gridLength = grid.length;
        int length = grid[0].length;
        int size = 0;
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] != 0){
                    size++;
                    if (grid[i][j] == 2){
                        int index = length * i + j;
                        queue.offer(index);
                        set.add(index);
                    }
                }
            }
        }
        queue.add(-1);
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            if (poll == -1){
                if (queue.isEmpty()){
                    break;
                }
                time ++;
                queue.offer(-1);
                poll = queue.poll();
            }
            int i = poll / length;
            int j = poll % length;
            for (int k = 0; k < 4; k++) {
                int newI = i + addX[k];
                int newJ = j + addY[k];
                if(newI >= 0 && newI < gridLength && newJ >= 0 && newJ < length){
                    if (grid[newI][newJ] == 1){
                        grid[newI][newJ] = 2;
                        int index = newI * length + newJ;
                        queue.add(index);
                        set.add(index);
                    }
                }
            }
        }
        return size == set.size() ? time : -1;
    }
}
