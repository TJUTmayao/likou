package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NO97
 * @Description 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * @Author 11432
 * @DATE 2019/7/31 15:25
 */
public class NO97 {

    public static void main(String[] args) {
        NO97 no97 = new NO97();
        System.out.println(no97.findDisappearedNumbers2(new int[]{4,3,2,7,8,2,3,1}));
    }
    /** 排序 */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        quickSort(nums,0,nums.length - 1);
        int n = 1;
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            while (n <= nums[i]){
                if (n < nums[i] && n != nums[last]){
                    list.add(n);
                }
                n++;
            }
            last = i;
        }
        for (; n <= nums.length ; n++) {
            list.add(n);
        }
        return list;
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
        for (int i = start; i < end; i++) {
            if (nums[i] <= mid){
                int s = nums[i];
                nums[i] = nums[j];
                nums[j] = s;
                j ++;
            }
        }
        nums[end] = nums[j];
        nums[j] = mid;
        return j;
    }

    /** 将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。*/
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int[] ints = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i] - 1] = -1;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0){
                list.add(i + 1);
            }
        }
        return list;
    }
}
