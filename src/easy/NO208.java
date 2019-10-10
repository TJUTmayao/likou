package easy;

import java.util.HashSet;

/**
 * @ClassName NO208
 * @Description 你将得到一个字符串数组 A。
 *
 * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
 *
 * 一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，交换 S[j] 和 S [i]。
 *
 * 现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
 *
 * 返回 A 中特殊等价字符串组的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/groups-of-special-equivalent-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/13 14:33
 */
public class NO208 {
    public static void main(String[] args) {
        NO208 no208 = new NO208();
        System.out.println(no208.numSpecialEquivGroups(new String[]{"abcd","cdab","cbad","xyzz","zzxy","zzyx"}));
    }
    /** 对每一个字符串的奇数位排序 和 偶数位排序 ，若排序结果相同则表示是特殊等价的 */
    public int numSpecialEquivGroups(String[] A) {
        int num = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            String string = getPai(A[i].toCharArray());
            if (!set.contains(string)){
                num ++;
                set.add(string);
            }
        }
        return num;
    }
    /** 将字符串的奇数位和偶数位分别排序 */
    public String getPai(char[] str){
        int j;
        for (int i = 0; i < str.length; i++) {
            j = i + 1;
            for (int k = i + 2,n = j + 2; k < str.length; k += 2,n += 2) {
                if (str[i] > str[k]){
                    char s = str[i];
                    str[i] = str[k];
                    str[k] = s;
                }
                if (n < str.length && str[j] > str[n]){
                    char s = str[j];
                    str[j] = str[n];
                    str[n] = s;
                }
            }
        }
        return new String(str);
    }
}
