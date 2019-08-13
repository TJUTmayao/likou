package easy;

/**
 * @ClassName NO140
 * @Description 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * @Author 11432
 * @DATE 2019/8/13 16:50
 */
public class NO140 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(0));
    }
    public static boolean judgeSquareSum(int c) {
        int st = 0,en = c > 46340 ? 46340 : c;
        int mid = 1;
        while (st <= en){
            mid = st + ((en - st) >> 1);
            int ji = mid * mid;
            if (ji > c){
                en = mid - 1;
            }else {
                if (ji == c){
                    return true;
                }
                st = mid + 1;
            }
        }
        st = 1;
        while (st <= mid){
            en = st * st + mid * mid;
            if (en <= c){
                if (en == c){
                    return true;
                }
                st ++;
            }else {
                mid --;
            }
        }
        return false;
    }
}
