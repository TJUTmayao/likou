package easy;

import javax.swing.text.Keymap;
import java.util.HashMap;

/**
 * @ClassName NO70
 * @Description 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * @Author 11432
 * @DATE 2019/7/19 18:28
 */
public class NO70 {
    private int[] buffer;

    /** 尽量不要用新变量 */
    public NO70(int[] nums) {
        buffer = new int[nums.length + 1];
        buffer[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            buffer[i + 1] = buffer[i] + nums[i];
        }
    }
    public int sumRange(int i, int j) {
        return buffer[j + 1] - buffer[i];
    }
}
