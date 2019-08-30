package easy;

/**
 * @ClassName NO175
 * @Description 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 *
 * 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
 *
 * 返回到达终点需要的最小移动次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reach-a-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/28 14:59
 */
public class NO175 {

    public static void main(String[] args) {
        NO175 no175 = new NO175();
        System.out.println(no175.reachNumber(2));
    }
    /**
     如果sum=target，毫无疑问那么k就是最终答案。

     当sum-target为偶数，1+...-（sum-target）/2+...+k=target，那么答案依然是k。#2

     当sum-target为奇数，那么sum-target+1是一个偶数 1+...-(sum-target+1)/2+...k = target-1

     此时再考虑k的奇偶性，如果k是偶数并且k > sum-target+1

     那么 1+...-(sum-target+1)/2+....-(k/2)...+k+(k+1) = target = 1+...-(sum-target+1)/2+...k + 1

     等价于sum +（k+1）-(sum-target+1)-k ====> target也就是答案是k+1。

     如果k是奇数：

     1+2+...-(sum-target+1)/2.....+k-(k+1)+(k+2)=sum-(sum-target+1)+1=target,

     因此答案是k+2.*/
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        int i = 0;
        while (target != sum){
            if (target > sum){
                sum += i + 1;
            }else {
                int k = sum - target;
                if ((k) % 2 == 0){
                    return i;
                }else {
                    k++;
                    if(i % 2 == 0){
                        return i + 1;
                    }else {
                        return i + 2;
                    }
                }
            }
            i++;
        }
        return i;
    }


}
