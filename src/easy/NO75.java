package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName NO75
 * @Description 给定两个数组，编写一个函数来计算它们的交集。
 * @Author 11432
 * @DATE 2019/7/20 16:52
 */
public class NO75 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer integer = map.get(nums1[i]);
            if (integer != null){
                map.put(nums1[i],integer + 1);
            }else {
                map.put(nums1[i],1);
            }
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            Integer integer = map.get(nums2[i]);
            if (integer != null && integer > 0){
                map.put(nums2[i],integer - 1);
                integers.add(nums2[i]);
            }
        }
        int[] ints = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ints[i] = integers.get(i);
        }
        return ints;
    }


    /** 快排 ---------------------------------------------------------------------------------------------------------*/

    public static void main(String[] args) {
        NO75 no75 = new NO75();
        System.out.println(no75.intersect2(new int[]{4,9,5},new int[]{9,4,9,8,4}));
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        // 排序
        quickSort(nums1,0,nums1.length - 1);
        quickSort(nums2,0,nums2.length - 1);
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0,j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]){
                integers.add(nums1[i]);
                i ++;
                j ++;
            }else {
                if (nums1[i] > nums2[j]){
                    j ++;
                }else {
                    i ++;
                }
            }
        }
        int[] ints = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ints[i] = integers.get(i);
        }
        return ints;
    }

    /** 每次根据中间值对数组排序，在分别对中间值左边和右边排序（仅把数组分为小于等于中间值和大于中间值两部分） */
    public void quickSort(int[] nums,int start,int end){
        if (start >= end){
            return;
        }
        int mid = sort(nums,start,end);
        quickSort(nums,start,mid - 1);
        quickSort(nums,mid + 1,end);
    }

    /** 将比中间值小的放左边，其余放右边 ，返回中间值的位置  稳定 */
    public int sort(int[] nums,int start,int end){
        int mid = nums[end];
        int s,j = start;
        for (int i = start; i < end;) {
            if (nums[i] <= mid){
                s = nums[i];
                nums[i] = nums[j];
                nums[j] = s;
                j ++;
            }
            i ++;
        }
        nums[end] = nums[j];
        nums[j] = mid;
        return j;
    }
}
