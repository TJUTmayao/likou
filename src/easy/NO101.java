package easy;

/**
 * @ClassName NO101
 * @Description 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 *              给出两个整数 x 和 y，计算它们之间的汉明距离
 *              x,y > 0
 * @Author 11432
 * @DATE 2019/8/2 17:58
 */
public class NO101 {
    public int hammingDistance(int x, int y) {
        int num = 0;
        while (x != 0 || y != 0){
            if ( ((x & 1)^(y & 1)) == 1){
                num ++;
            }
            x >>= 1;
            y >>= 1;
        }
        return num;
    }
}
