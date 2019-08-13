package easy;

/**
 * @ClassName NO136
 * @Description 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * @Author 11432
 * @DATE 2019/8/12 18:33
 */
public class NO136 {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,1,0,0,1,0},1));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i,j;
        if (flowerbed.length == 1 && flowerbed[0] == 0){
            return n - 1 <= 0;
        }
        for (i = 0,j = -1; i < flowerbed.length;) {
            if (flowerbed[i] == 1){
                if (j == -1){
                    n -= (i - j - 1) / 2;
                }else {
                    n -= (i - j) / 2 - 1;
                }
                j = i;
            }
            i ++;
        }
        if (flowerbed[i - 1] == 0){
            if (j == -1){
                i ++;
            }
            n -= (i - 1 - j) / 2;
        }
        return n <= 0;
    }
}
