package easy;

import java.util.ArrayList;

/**
 * @ClassName NO235
 * @Description： <p> 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-town-judge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 </p>
 * @Author mayao
 * @Date 2019/10/6 16:21
 */
public class NO235 {
    class Solution {
        public int findJudge(int N, int[][] trust) {
            if (N == 1){
                return 1;
            }
            int max = N - 1;
            int[] ints = new int[N + 1];
            boolean[] is = new boolean[N + 1];
            ArrayList<Integer> list = new ArrayList<>();
            for (int[] arr : trust) {
                ints[arr[1]] ++;
                is[arr[0]] = true;
                if (ints[arr[1]] == max){
                    list.add(arr[1]);
                }
            }
            for (Integer integer : list) {
                if (!is[integer]){
                    return integer;
                }
            }
            return  -1;
        }
    }
}
