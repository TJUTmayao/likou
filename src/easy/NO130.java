package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName NO130
 * @Description 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * @Author 11432
 * @DATE 2019/8/11 16:25
 */
public class NO130 {
    /** 时间换空间 */
    public int distributeCandies(int[] candies) {
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            map.add(candies[i]);
        }
        int can = candies.length >> 1;
        return map.size() > can ? can : map.size();
    }

    /** 空间换时间 */
    public int distributeCandies2(int[] candies) {
        int[] ints = new int[200001];
        int num = 0;
        int can = candies.length >> 1;
        for (int i = 0; i < candies.length; i++) {
            int k = candies[i] + 100000;
            if (ints[k] == 0){
                ints[k] = 1;
                num++;
                if (num == can){
                    return num;
                }
            }
        }
        return num;
    }

    /** 排序 */
    public int distributeCandies3(int[] candies) {
        Arrays.sort(candies);
        int num = 0;
        int can = candies.length >> 1;
        int last = Integer.MAX_VALUE;
        for (int i = 0; i < candies.length; i++) {
            if (last != candies[i]){
                num++;
                if (num == can){
                    return can;
                }
                last = candies[i];
            }
        }
        return num;
    }

    /** 平衡版 比空间换时间快的原因 ？1、每次遍历200000次。 */
    public int distributeCandies4(int[] candies) {
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            min = Math.min(min,candies[i]);
            max = Math.max(max,candies[i]);
        }
        int[] ints = new int[max - min + 1];
        int num = 0;
        int can = candies.length >> 1;
        for (int i = 0; i < candies.length; i++) {
            int k = candies[i] - min;
            if (ints[k] == 0){
                ints[k] = 1;
                num++;
                if (num == can){
                    return num;
                }
            }
        }
        return num;
    }
}
