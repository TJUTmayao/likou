package easy;

/**
 * @ClassName NO171
 * @Description 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 *
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/25 16:12
 */
public class NO171 {
    public char nextGreatestLetter(char[] letters, char target) {
        int i;
        if (letters[letters.length - 1] <= target){
            return letters[0];
        }
        for (i = 0; i < letters.length; i++) {
            if (letters[i] > target){
                return letters[i];
            }
        }
        return 0;
    }
}
