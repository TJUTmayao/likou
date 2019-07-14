package easy;

/**
 * @ClassName NO46
 * @Description 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 *              如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *              给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * @Author 11432
 * @DATE 2019/7/14 13:19
 */
public class NO46 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    /** 穷举法 动态规划 */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[][] states = new int[nums.length][2];
        states[0][1] = nums[0];
        states[0][0] = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            states[i][0] = Math.max(states[i - 1][0],states[i - 1][1]);
            states[i][1] = states[i - 1][0] + nums[i];
            int max1 = Math.max(states[i][0], states[i][1]);
            if (max1 > max){
                max = max1;
            }
        }
        return max;
    }

}
