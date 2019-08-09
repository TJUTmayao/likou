package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName NO118
 * @Description 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
 * 这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，
 * 且两数之差的绝对值是 k.
 *
 * @Author 11432
 * @DATE 2019/8/9 14:59
 */
public class NO118 {
    public static void main(String[] args) {
        NO118 no118 = new NO118();
        System.out.println(no118.findPairs(new int[]{1,1,3,4,5},0));
    }
    public int findPairs(int[] nums, int k) {
        if (k < 0){
            return 0;
        }
        Arrays.sort(nums);
        int num = 0;
        for (int i = 0,j = 1; i < nums.length && j < nums.length;) {
            while (j < nums.length - 1 && nums[j] == nums[j + 1]){
                j ++;
            }
            int s = nums[j] - nums[i];
            if (s == k){
                num ++;
                i ++;
                j ++;
            }else if (s < k){
                j ++;
            }else if (s > k){
                i ++;
            }
            if (i == j){
                j++;
            }
        }
        return num;
    }

    public void quickSort(int[] nums,int start,int end){
        if (start > end){
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

}
