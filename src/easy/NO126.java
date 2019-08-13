package easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName NO126
 * @Description 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * @Author 11432
 * @DATE 2019/8/10 17:18
 */
public class NO126 {
    public int arrayPairSum(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        int num = 0;
        for (int i = 0; i < nums.length; i += 2) {
            num += nums[i];
        }
        return num;
    }

    public void quickSort(int[] nums,int start,int end){
        if (start >= end){
            return;
        }
        int sort = sort(nums, start, end);
        quickSort(nums,start,sort - 1);
        quickSort(nums,sort + 1,end);
    }

    public int sort(int[] nums,int start,int end){
        int mid = nums[end];
        int j = start;
        int k;
        for (int i = start; i < end; i++) {
            if (nums[i] <= mid){
                k = nums[i];
                nums[i] = nums[j];
                nums[j] = k;
                j ++;
            }
        }
        nums[end] = nums[j];
        nums[j] = mid;
        return j;
    }


    /** 取巧 */
    public int arrayPairSum2(int[] nums) {
        int[] ints = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i] + 10000] ++;
        }
        boolean x = false;
        int k = 0;
        int num = 0;
        for (int i = 0; i < ints.length; i++) {
            while (ints[i] != 0){
                if (x){
                    num += k;
                    x = false;
                }else {
                    k = i - 10000;
                    x = true;
                }
                ints[i] --;
            }
        }
        return num;
    }
}
