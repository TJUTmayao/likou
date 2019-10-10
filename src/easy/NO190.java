package easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName NO190
 * @Description 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 *
 * 最终结果按照字典顺序输出。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/2 15:02
 */
public class NO190 {
    public List<List<Integer>> largeGroupPositions(String S) {
        S = S + "#";
        List<List<Integer>> res = new ArrayList<>();
        int num = 1;
        for (int i = 1,j = 0; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)){
                if (num >= 3){
                    res.add(Arrays.asList(new Integer[]{j,i-1}));
                }
                num = 1;
                j = i;
            }else {
                num++;
            }
        }
        return res;
    }
}
