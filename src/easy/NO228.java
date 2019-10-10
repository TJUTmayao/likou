package easy;

import java.util.*;

/**
 * @ClassName NO228
 * @Description 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
 *
 * 返回值小于或等于 bound 的所有强整数组成的列表。
 *
 * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 * 注：X^n == X的n次方
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powerful-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/23 14:43
 */
public class NO228 {

    public static void main(String[] args) {
        NO228 no228 = new NO228();
        System.out.println(no228.powerfulIntegers(2,3,10));
    }
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> res = new HashSet<>();
        if (bound < 2){
            return new ArrayList<>();
        }
        if (x == 1 && y == 1){
            return Arrays.asList(2);
        }
        List<Integer> xN = getN(x, bound);
        List<Integer> yN = getN(y, bound);
        for (Integer integerY : yN) {
            for (Integer integerX : xN) {
                int k = integerX + integerY;
                if (k <= bound){
                    res.add(k);
                }
            }
        }
        return new ArrayList<>(res);
    }
    public List<Integer> getN(int x, int bound) {
        List<Integer> xN = new ArrayList<>();
        if (x == 1){
            xN.add(1);
        }else {
            int k = 1;
            while (k < bound) {
                xN.add(k);
                k *= x;
            }
        }
        return xN;
    }
}
