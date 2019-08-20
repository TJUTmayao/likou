package easy;

/**
 * @ClassName NO147
 * @Description 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/16 16:36
 */
public class NO147 {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4,2,1}));
    }
    public static boolean checkPossibility(int[] nums) {
        int num = 0;
        int x,y;
        int m,n;
        if (nums.length == 0){
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]){
                x = 0;y = 0;
                m = i - 1;
                while (m >= 0 && nums[m] > nums[i]){
                    m --;
                    x ++;
                }
                n = i;
                while (n < nums.length && nums[i - 1] > nums[n]){
                    n ++;
                    y ++;
                }
                num += Math.min(x,y);
                if (num > 1){
                    return false;
                }
            }
        }
        return true;
    }
}
