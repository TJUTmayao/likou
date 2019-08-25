package easy;

/**
 * @ClassName NO168
 * @Description 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 *
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/24 14:39
 */
public class NO168 {
    public static void main(String[] args) {
        NO168 no168 = new NO168();
        System.out.println(no168.pivotIndex(new int[]{1,7,3,6,5,6}));
    }
    public int pivotIndex(int[] nums) {
        int numSize = nums.length;
        if (numSize == 0){
            return -1;
        }
        int[] sums = new int[numSize];
        sums[0] = nums[0];
        for (int i = 1; i < numSize; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int i = 0; i < numSize; i++) {
            if (sums[i] - nums[i] == sums[numSize - 1] - sums[i]){
                return i;
            }
        }
        return -1;
    }
}
