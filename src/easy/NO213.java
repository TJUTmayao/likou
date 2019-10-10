package easy;

import org.omg.CORBA.MARSHAL;

/**
 * @ClassName NO213
 * @Description 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/13 16:29
 */
public class NO213 {
    public static void main(String[] args) {
        NO213 no213 = new NO213();
        System.out.println(no213.hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1}));
    }
    public boolean hasGroupsSizeX(int[] deck) {
        int[] ints = new int[10000];
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < deck.length; i++) {
            ints[deck[i]] ++;
            if (max < deck[i]){
                max = deck[i];
            }
        }
        for (int i = 0; i <= max; i++) {
            if (ints[i] != 0 && min > ints[i]){
                min = ints[i];
            }
        }
        if (min < 2){
            return false;
        }
        for (int i = 0; i <= max; i++) {
            if (ints[i] != 0 && ints[i] % min != 0){
                do {
                    min --;
                }while (ints[i] % min != 0);
                if (min < 2){
                    return false;
                }
            }
        }
        return min > 1;
    }
}
