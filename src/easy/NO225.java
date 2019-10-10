package easy;

/**
 * @ClassName NO225
 * @Description 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verifying-an-alien-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/21 18:29
 */
public class NO225 {
    public static void main(String[] args) {
        NO225 no225 = new NO225();
        System.out.println(no225.isAlienSorted(new String[]{"apple","app"},
        "abcdefghijklmnopqrstuvwxyz"));
    }
    public boolean isAlienSorted(String[] words, String order) {
        int[] ints = new int[124];
        for (int i = 0; i < order.length(); i++) {
            ints[order.charAt(i)] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1],words[i],ints) >= 0){
                return false;
            }
        }
        return true;
    }

    public int compare(String s1,String s2,int[] order){
        int l1 = s1.length();
        int l2 = s2.length();
        int size = Math.min(l1,l2);
        for (int i = 0; i < size; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (order[c1] != order[c2]){
                return order[c1] - order[c2];
            }
        }
        if (l1 == l2){
            return 0;
        }
        return l1 - l2;
    }
}
