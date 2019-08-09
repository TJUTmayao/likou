package easy;

import java.util.Arrays;

/**
 * @ClassName NO103
 * @Description 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 *
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径
 *
 * @Author 11432
 * @DATE 2019/8/4 15:39
 */
public class NO103 {
    public static void main(String[] args) {
        System.out.println(findRadius2(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923},
                new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}));
    }
    /** 排序 */
    public static int findRadius(int[] houses, int[] heaters) {
        int j = 0;
        int x,y;
        int min = 0;
        Arrays.sort(heaters);
        Arrays.sort(houses);
        for (int i = 0; i < houses.length;) {
            if (heaters[j] >= houses[i] || j == heaters.length - 1){
                x = Math.abs(heaters[j] - houses[i]);
                i ++;
            }else {
                x = Math.abs(houses[i] - heaters[j]);
                y = Math.abs(houses[i] - heaters[j + 1]);
                if (x < y){
                    i ++;
                }else {
                    j ++;
                    continue;
                }
            }
            if (min < x){
                min  = x;
            }
        }
        return min;
    }
    /** 二分 */
    public static int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int min = 0;
        for (int i = 0; i < houses.length; i++) {
            int min1 = findMin(heaters, houses[i]);
            if (min < min1){
                min = min1;
            }
        }
        return min;
    }

    public static int findMin(int[] heaters,int tar){
        int start = 0;
        int end = heaters.length - 1;
        int mid;
        int min = Integer.MAX_VALUE;
        int  k;
        while (start <= end){
            mid = start + ((end - start) >> 1);
            if (heaters[mid] <= tar){
                if (heaters[mid] == tar){
                    return 0;
                }
                k = Math.abs(tar - heaters[mid]);
                start = mid + 1;
            }else {
                k = Math.abs(tar - heaters[mid]);
                end = mid - 1;
            }
            min = min > k ? k : min;
        }
        return min;
    }

}
