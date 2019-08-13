package easy;

/**
 * @ClassName NO142
 * @Description 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * @Author 11432
 * @DATE 2019/8/13 18:01
 */
public class NO142 {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{0,4,0,3,2},1));
    }
    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;
        for (int i = 1,j = k; j < nums.length; i++,j++) {
            sum += nums[j] - nums[i - 1];
            if (sum > max){
                max = sum;
            }
        }
        return max / k;
    }
}
