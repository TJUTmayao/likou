package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName NO34
 * @Description 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 *              说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @Author 11432
 * @DATE 2019/7/10 15:10
 */
public class NO34 {

    public static void main(String[] args) {
        new NO34();
    }

    /** 位运算  一个数连续异或某个数两次 = 它本身   +  逻辑运算的交换律 A^B^C = B^A^C */
                    /** A^0 = A  结合  A^A = 0 */
    public int singleNumber(int[] nums) {
        int onlyOne = 0;
        for (int i = 0; i < nums.length; i++) {
            onlyOne = onlyOne ^ nums[i];
        }
        return onlyOne;
    }

    /** 数学法 */
    public int singleNumber2(int[] nums) {
        long num1 = 0;
        long num2 = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            num2 += nums[i];
        }
        for (Integer integer : set) {
            num1 += integer << 1;
        }
        return (int) (num1 - num2);
    }

    /** hash表 */
    public int singleNumber3(int[] nums) {
        Map<Integer,Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.containsKey(nums[i])){
                set.put(nums[i],set.get(nums[i]) + 1);
            }else {
                set.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : set.entrySet()) {
            if (integerIntegerEntry.getValue() == 1){
                return integerIntegerEntry.getKey();
            }
        }
        return 0;
    }

}
