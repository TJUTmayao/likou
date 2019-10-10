package easy;

/**
 * @ClassName NO256
 * @Description： <p> 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/available-captures-for-rook
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 </p>
 * @Author mayao
 * @Date 2019/10/7 13:38
 */
public class NO256 {
    public static void main(String[] args) {
        int i = numRookCaptures(new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}});
        System.out.println(i);
    }
    public static int numRookCaptures(char[][] board) {
        int i,j = 0;
        int length = board.length;
        int size = board[0].length;
        for (i = 0; i < length; i++) {
            for (j = 0; j < size; j++) {
                if (board[i][j] == 'R'){
                    break;
                }
            }
            if (j < size){
                break;
            }
        }
        int num = 0;
        int[] nX = new int[]{-1,0,1,0};
        int[] nY = new int[]{0,1,0,-1};
        for (int k = 0; k < 4; k++) {
            int x = i;
            int y = j;
            while (x >= 0 && x < length && y >= 0 && y <size){
                if (board[x][y] == 'B'){break;}
                if (board[x][y] == 'p'){
                    num ++;break;
                }
                else {
                    x += nX[k];
                    y += nY[k];
                }
            }
        }
        return num;
    }
}
