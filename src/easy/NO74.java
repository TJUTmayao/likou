package easy;

import java.util.*;

/**
 * @ClassName NO74
 * @Description 给定两个数组，编写一个函数来计算它们的交集。
 * @Author 11432
 * @DATE 2019/7/20 16:24
 */
public class NO74 {
    /** hash 表 */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        int i = 0;
        int[] ints = new int[res.size()];
        for (Integer re : res) {
            ints[i++] = re;
        }
        return ints;
    }

    /** 库函数 */
    public int[] intersection2(int[] nums1, int[] nums2) {
        ArrayList<Integer> n1 = new ArrayList<>();
        ArrayList<Integer> n2 = new ArrayList<>();
        for (int i : nums1) {
            n1.add(i);
        }
        for (int i : nums2) {
            n2.add(i);
        }
        n1.retainAll(n2);
        int[] ints = new int[n1.size()];
        int i = 0;
        for (Integer integer : n1) {
            ints[i++] = integer;
        }
        return ints;
    }
}
