package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NO96
 * @Description 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 *
 * @Author 11432
 * @DATE 2019/7/31 13:59
 */
public class NO96 {
    public static void main(String[] args) {
        NO96 no96 = new NO96();
        System.out.println(no96.numberOfBoomerangs(new int[][]{{0,0},
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}}));
    }

    /** 某个点的所有回旋镖 = 所有 该点到其他点的相同距离的数量n * （n-1） 之和 */
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Double, Integer> map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j){
                    continue;
                }
                double distance = getDistance(points[i][0] - points[j][0],points[i][1] - points[j][1]);
                Integer integer = map.get(distance);
                if (integer != null){
                    map.put(distance,integer + 1);
                    num += integer * 2;
                }else {
                    map.put(distance,1);
                }
            }
            map.clear();
        }
        return num;
    }

    public double getDistance(int x,int y){
        return Math.sqrt((Math.pow(x,2) + Math.pow(y,2)));
    }
}
