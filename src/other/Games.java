package other;

/**
 * @ClassName Games
 * @Description 你和你的朋友面前有一排石头堆，用一个数组 piles 表示，piles[i] 表示第 i 堆石子有多少个。
 * 你们轮流拿石头，一次拿一堆，但是只能拿走最左边或者最右边的石头堆。所有石头被拿完后，谁拥有的石头多，谁获胜。
 * @Author 11432
 * @DATE 2019/8/25 16:55
 */
public class Games {
    public static void main(String[] args) {
        System.out.println(getWinerAndLoser(3,9,1,2));
    }

    public static int getWinerAndLoser(int... piles){
        // 状态数组
        Node[][] states = new Node[piles.length][piles.length];
        // 初始化 当只有一堆石头时的情况
        for (int i = 0; i < piles.length; i++) {
            states[i][i] = new Node();
            // 先手取得这石头
            states[i][i].F = piles[i];
            // 后手没有石头可取
            states[i][i].S = 0;
        }
        // 动态规划 当只有 i+1 堆石头时，i递增直到 piles.length 堆石头
        // （每次只在右边添加一堆石头，保证添加之前的选择不受添加之后的选择的影响）
        for (int i = 1; i < piles.length; i++) {
            for (int j = 0; j + i< piles.length; j++) {
                // j 为石头堆得起始下标，k 为石头堆的末尾下标
                int k = j + i;
                states[j][k] = new Node();
                // 本次先手选择左边还是右边，取决于下一次后手者的选择
                // （即只有 i+1-1 堆石头时的后手,这时，由于是从 1 堆到 piles.length 堆石头的方向，i+1-1堆石头的情形已经算出）
                //    选择左边的石头堆                  选择右边的石头堆
                if(states[j + 1][k].S + piles[j] >= states[j][k - 1].S + piles[k]){
                    // 本次的先手 = 下一次的后手 + 本次选择的石头数
                    states[j][k].F = states[j + 1][k].S + piles[j];
                    // 本次的后手 = 下一次的先手
                    states[j][k].S = states[j + 1][k].F;
                }else {
                    states[j][k].F = states[j][k - 1].S + piles[k];
                    states[j][k].S = states[j][k - 1].F;
                }
            }
        }
        // 最后(0，piles.length - 1)为所有石头堆的最优选择
        return Math.max(states[0][piles.length - 1].S,states[0][piles.length - 1].F);
    }

    private static class Node{
        int F;
        int S;
    }
}
