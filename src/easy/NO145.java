package easy;

/**
 * @ClassName NO145
 * @Description 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 *
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，
 *
 * 则返回 true。否则，返回 false。
 *
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/robot-return-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/16 15:18
 */
public class NO145 {
    public static void main(String[] args) {
        System.out.println('R'-'A');
        System.out.println('L'-'A');
    }
    public boolean judgeCircle(String moves) {
        int[] ints = new int[26];
        for (char c : moves.toCharArray()){
            ints[c - 'A'] ++;
        }
        return ints[3] == ints[20] && ints[17] == ints[11];
    }
}
