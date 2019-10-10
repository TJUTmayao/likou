package easy;

/**
 * @ClassName NO186
 * @Description 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * @Author 11432
 * @DATE 2019/8/31 15:21
 */
public class NO186 {
    /** 海伦公式 ： P = a + b + c  面积 = 根号 P*(P-a)(P-b)(P-c)*/
    public double largestTriangleArea(int[][] points) {
        int aX = -1;
        int aY = -1;
        int bX = -1;
        int bY = -1;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                if (points[i][j] != 0){
                    if (aX == -1){
                        aX = i;
                        aY = j;
                    }else {
                        bX = i;
                        bY = j;
                        break;
                    }
                }
            }
        }
        return 0;
    }
}
