package easy;

/**
 * @ClassName NO31
 * @Description 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *              如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *              注意你不能在买入股票前卖出股票。
 * @Author 11432
 * @DATE 2019/7/8 12:39
 */
public class NO31 {

    /** 暴力法 超时 1069ms */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max){
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    /** 动态规划 */
    public int maxProfit2(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]){
                min = prices[i];
            }
            if (prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
}
