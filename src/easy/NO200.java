package easy;

/**
 * @ClassName NO200
 * @Description 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 *
 * 如果没有两个连续的 1，返回 0 。
 * @Author 11432
 * @DATE 2019/9/6 14:59
 */
public class NO200 {
    public static void main(String[] args) {
        NO200 no200 = new NO200();
        System.out.println(no200.binaryGap(8));
    }
    public int binaryGap(int N) {
        int max = 0;
        int size = -1;
        while (N != 0){
            if ((N & 1) == 1){
                if (size != -1){
                    max = Math.max(max,size);
                }
                size = 1;
            }else {
                if (size != -1){
                    size++;
                }
            }
            N >>= 1;
        }
        return max;
    }
}
