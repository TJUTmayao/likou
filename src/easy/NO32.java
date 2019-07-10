package easy;

/**
 * @ClassName NO32
 * @Description 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @Author 11432
 * @DATE 2019/7/9 11:07
 */
public class NO32 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }


    /** 穷举法  超时 */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int[][][] state = new int[prices.length][prices.length][2];
        int max = 0;
        int k = prices.length - 1;
        //初始化第一天的两种情况
        state[0][k][0] = 0;
        state[0][k][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            state[i][k - 1][0] = Math.max(state[i - 1][k][0],state[i - 1][k][1] + prices[i]);
            state[i][k - 1][1] = Math.max(state[i - 1][k][0] - prices[i],state[i - 1][k][1]);
            int max1 = Math.max(state[i][k - 1][0], state[i][k - 1][1]);
            k --;
            if (max < max1){
                max = max1;
            }
        }
        return max;
    }

    /** 贪心算法 */
    public static int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]){
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    /** 贪心算法前身 每一个连续的 |最低谷 - 最高峰| */
    public static int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]){
                min = prices[i];
            }else {
                //累加 |最低谷 - 高峰| 直到下一个低谷
                max += prices[i] - min;
                min = prices[i];
            }
        }
        return max;
    }

}
