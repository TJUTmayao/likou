package easy;

/**
 * @ClassName NO172
 * @Description 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/26 15:00
 */
public class NO172 {

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs2(new int[]{0,1,1,0}));
    }
    public static int minCostClimbingStairs(int[] cost) {
        //                          第几次      目标阶梯  =  花费
        int[] states = new int[cost.length];
        // 初始化第一次
        states[0] = cost[0];
        states[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            states[i] = Math.min(states[i - 1],states[i - 2]) + cost[i];
        }
        return Math.min(states[cost.length - 1],states[cost.length - 2]);
    }

    public static int minCostClimbingStairs2(int[] cost) {
        int last2 = cost[0];
        int last1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int k = last1;
            last1 = Math.min(last1,last2) + cost[i];
            last2 = k;
        }
        return Math.min(last1,last2);
    }
}
