package easy;

import java.util.ArrayList;

/**
 * @ClassName NO158
 * @Description 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/21 15:56
 */
public class NO158 {
    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1}));
    }
    public static int findShortestSubArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        int[] count = new int[max - min + 1];
        int[] index = new int[max - min + 1];
        int[] lastIndex = new int[max - min + 1];
        max = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i] - min;
            count[k] ++;
            if (index[k] == 0){
                index[k] = i + 1;
            }
            lastIndex[k] = i;
            max = Math.max(max,count[k]);
        }
        int res = nums.length;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max){
                res = Math.min(lastIndex[i] - index[i] + 2,res);
            }
        }
        return res;
    }
}
