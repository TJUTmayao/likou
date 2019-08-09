package easy;

import java.util.HashMap;

/**
 * @ClassName NO108
 * @Description 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * @Author 11432
 * @DATE 2019/8/6 9:36
 */
public class NO108 {
    public static void main(String[] args) {
        nextGreaterElement(new int[]{4,1,2},new int[]
                {1,3,4,2});
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextBig = new HashMap<>();
        int j;
        for (int i = 0; i < nums2.length; i++) {
            j = i + 1;
            while (j < nums2.length && nums2[j] <= nums2[i]){
                j++;
            }
            if (j < nums2.length){
                nextBig.put(nums2[i],nums2[j]);
            }
        }
        int[] ints = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Integer integer = nextBig.get(nums1[i]);
            if (integer != null){
                ints[i] = integer;
            }else {
                ints[i] = -1;
            }
        }
        return ints;
    }
}
