package other;

/**
 * @ClassName EightQueen
 * @Description TODO
 * @Author 11432
 * @DATE 2019/7/23 15:22
 */
public class EightQueen {
    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen(new int[]{0, 4, 5, 7, 1, 6, 2, 3});
        int index = 0;
        eightQueen.huisu(0);
        System.out.println(eightQueen.num);
    }

    int[] res = new int[8];
    int num = 0;

    public EightQueen(int[] res) {
        this.res = res;
    }

    public void huisu(int line){
        if (line == 8){
            printQueens(res);
            num ++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (check(line,i)){
                res[line] = i;
                huisu(line + 1);
            }
        }
    }

    public boolean check(int line,int column){
        int x = 1;
        for (int i = 0; i < line; i++) {
            // 检查是否有在同一行的
            if (i == line){
                return false;
            }
            // 检查是否有在同一列的
            if (res[i] == column){
                return false;
            }
            if (line - x < 0){
                continue;
            }
            // 检查左上角
            if (res[line - x] == column - x){
                return false;
            }
            // 检查右上角
            if (res[line - x] == column + x){
                return false;
            }
            x ++;
        }
        return true;
    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
