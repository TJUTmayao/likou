package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NO257
 * @Description： <p> 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 </p>
 * @Author mayao
 * @Date 2019/10/7 14:07
 */
public class NO257 {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella","label","roller"}));
    }
    public static List<String> commonChars(String[] A) {
        int length = A.length;
        int[] mins = new int[26];
        for (int i = 0; i < mins.length; i++) {
            mins[i] = 1000;
        }
        int[] charNum = new int[26];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                charNum[A[i].charAt(j) - 97] ++;
            }
            for (int j = 0; j < mins.length; j++) {
                mins[j] = Math.min(mins[j],charNum[j]);
                charNum[j] = 0;
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (int j = 0; j < mins.length; j++) {
            while (mins[j]-- > 0){
                list.add(String.valueOf((char) (j + 97)));
            }
        }
        return list;
    }
}
