package easy;

/**
 * @ClassName NO153
 * @Description 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 *
 * 举个例子，A = "abcd"，B = "cdabcdab"。
 *
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 *
 * 注意:
 *
 *  A 与 B 字符串的长度在1和10000区间范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/17 17:31
 */
public class NO153 {
    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("aabaa",
                "aaab"));
    }
    /** 若B是A重复叠加两次及以上的子串，那么A一定存在与 B的前缀 相同的后缀，并且 B的该前缀 之后的字符一定与A的前缀相同（可以是A本身）
     *  若B是A的子串，则正常查找
     * */
    public static int repeatedStringMatch(String A, String B) {
        int i = 0,j = 0;
        int num = 0;
        // 记录下次查找开始点
        int la = -1;
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        while (true){
            if (charA[i] == charB[j]){
                if (la == -1){
                    la = i;
                }
                j++;
                if (j >= charB.length){
                    return num + 1;
                }
            }else {
                // 如果在两次重复叠加之内有不同的字符
                if (num <= 1){
                    j = 0;
                    // 从上一次匹配的起点的下一个字符重新开始匹配
                    if (la != -1){
                        // 去除重新匹配造成的额外叠加次数
                        if (la > i){
                            num--;
                        }
                        i = la;
                        la = -1;
                    }
                }else {
                    return -1;
                }
            }
            // 循环遍历A中的字符（即重复叠加）
            i = (i + 1) % charA.length;
            // 当遍历A一次后，叠加次数+1
            if (i == 0){
                num++;
            }
        }
    }
}
