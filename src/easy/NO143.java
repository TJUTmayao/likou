package easy;

/**
 * @ClassName NO143
 * @Description 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，
 * 导致集合丢失了一个整数并且有一个元素重复。给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，
 * 再找到丢失的整数，将它们以数组的形式返回。
 *
 * @Author 11432
 * @DATE 2019/8/13 18:27
 */
public class NO143 {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int sum = nums.length * (nums.length + 1) >> 1;
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]]++;
            sum -= nums[i];
            if (ints[nums[i]] > 1){
                res[0] = nums[i];
            }
        }
        res[1] = sum + res[0];
        return res;
    }
}
