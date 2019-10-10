package easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName NO202
 * @Description 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人的最大欧式距离的平方。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/6 15:32
 */
public class NO202 {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<String,Boolean> set = new HashMap<>();
        //方向              北 东 南 西
        int[] nX = new int[]{0,1,0,-1};
        int[] nY = new int[]{1,0,-1,0};
        int index = 0;
        for (int i = 0; i < obstacles.length; i++) {
            set.put(obstacles[i][0] + "," + obstacles[i][1],true);
        }
        int x = 0, y = 0;
        int max = 0;
        for (int command : commands) {
            if (command < 0){
                if (command == -1){
                    index = (index + 1) % 4;
                }else {
                    index = (index + 4 - 1) % 4;
                }
            }else {
                for (int j = 0; j < command; j++) {
                    x += nX[index];
                    y += nY[index];
                    if (set.containsKey(x + "," + y)){
                        x -= nX[index];
                        y -= nY[index];
                        break;
                    }
                }
                max = Math.max(max,x*x+y*y);
            }
        }
        return max;
    }

//    int max = 0;
//    int[][] dx = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//    int k = 0;
//    Map<String, Boolean> map = new HashMap<>();
//        for (int i = 0; i < obstacles.length; i++) {
//        map.put(obstacles[i][0] + "," + obstacles[i][1], true);
//    }
//    int p = 0, q = 0;
//        for (int command : commands) {
//        if (command == -1) {
//            k = (k + 1) % 4;
//        } else if (command == -2) {
//            k = (k + 4 - 1) % 4;
//        } else {
//            int cur[] = dx[k];
//            for (int i = 0; i < command; i++) {
//                if (map.containsKey((p + cur[0]) + "," + (q + cur[1]))) {
//                    break;
//                }
//                p += cur[0];
//                q += cur[1];
//            }
//            max = Math.max(max, p * p + q * q);
//        }
//    }
//        return max;
}
