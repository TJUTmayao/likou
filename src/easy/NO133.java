package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NO133
 * @Description 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * @Author 11432
 * @DATE 2019/8/12 17:03
 */
public class NO133 {
    public static void main(String[] args) {
        System.out.println(findLHS2(new int[]{1,3,5,7,9,11,13,15,17}));
    }
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int i,j;
        for (i = 0,j = 0; i < nums.length;) {
            int x = nums[i] - nums[j];
            if (x <= 1){
                if (x == 1){
                    max = Math.max(max,i - j + 1);
                }
                i++;
            }
            if (x > 1){
                j++;
            }
        }
        return max;
    }

    public static int findLHS2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        int[] ints = new int[max - min + 1];
        max = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i] - min;
            ints[k]++;
            if (k > 0 && ints[k - 1] > 0){
                max = Math.max(ints[k] + ints[k - 1],max);
            }
            if (k < ints.length - 1 && ints[k + 1] > 0){
                max = Math.max(ints[k] + ints[k + 1],max);
            }
        }
        return max;
    }

    public static int findLHS3(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer == null){
                map.put(num,1);
            }else {
                map.put(num,integer + 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            Integer integer = map.get(entry.getKey() + 1);
            if (integer != null){
                max = Math.max(max,integer + entry.getValue());
            }
        }
        return max;
    }
}
