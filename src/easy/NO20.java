package easy;

import sun.security.krb5.internal.tools.Kinit;

/**
 * @ClassName NO20
 * @Description 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * @Author 11432
 * @DATE 2019/7/6 8:15
 */
public class NO20 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int i = m - 1;
       int j = n - 1;
       int k = m + n - 1;
       for (;k >= 0 ;k --){
           if (i >= 0 && j >= 0){
               nums1[k] = nums1[i] > nums2[j] ? nums1[i --] : nums2[j --];
           }
           else {
               nums1[k] = i < 0 ? nums2[j --] : nums1[i --];
           }
       }
    }
}
