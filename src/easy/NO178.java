package easy;

/**
 * @ClassName NO178
 * @Description  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，
 * 你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/29 17:03
 */
public class NO178 {
    public int numJewelsInStones(String J, String S) {
        int[] upCase = new int[26];
        int[] lowCase = new int[26];
        int sum = 0;
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            if (Character.isLowerCase(c)){
                lowCase[c - 97] ++;
            }else {
                upCase[c - 65] ++;
            }
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isLowerCase(c)){
                if (lowCase[c - 97] > 0){
                    sum++;
                }
            }else{
                if (upCase[c - 65] > 0){
                    sum++;
                }
            }
        }
        return sum;
    }
}
