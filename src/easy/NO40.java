package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NO40
 * @Description 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * @Author 11432
 * @DATE 2019/7/12 17:43
 */
public class NO40 {
    /** 方法一  散列表 */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int modeNumber = nums[0];
        for (int num : nums) {
            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                Integer integer = map.get(num);
                map.put(num,++ integer);
                if (max < integer){
                    max = integer;
                    modeNumber = num;
                }
            }
        }
        return modeNumber;
    }

    /** 方法二 计数法 只适用于众数数量大于n/2的  */
    public int majorityElement2(int[] nums) {
        int modeNumber = nums[0];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == modeNumber){
                max ++;
            }else {
                max --;
            }
            if (max == 0){
                modeNumber = nums[i + 1];
            }
        }
        return modeNumber;
    }

    /** 方法三 分治*/
    public int majorityElement3(int[] nums) {
        return getModeNumber(nums,0,nums.length - 1);
    }
    public int getModeNumber(int[] nums,int start,int end){
        if (start >= end){
            return nums[start];
        }
        int middle = start + ((end - start) >> 1);
        int modeNumber1 = getModeNumber(nums, start, middle);
        int modeNumber2 = getModeNumber(nums, middle + 1, end);
        if (modeNumber1 == modeNumber2){
            return modeNumber1;
        }
        return getMax(nums,modeNumber1,modeNumber2,start,end);
    }
    /** 获取两个众数众最多的 */
    public int getMax(int[] nums,int i1,int i2,int start,int end){
        int x = 0,y = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == i1){
                x ++;
            }
            if (nums[i] == i2){
                y ++;
            }
        }
        return x > y ? i1 : i2;
    }
}
