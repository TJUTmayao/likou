package easy;

/**
 * @ClassName NO76
 * @Description TODO
 * @Author 11432
 * @DATE 2019/7/21 16:21
 */
public class NO76 {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(100489));
    }

    /** 二分法 */
    public static boolean isPerfectSquare(int num) {
        if (num == 1){
            return true;
        }
        int start = 1,end = num > 46340 ? 46340 : num;
        int mid,x = 0;
        while (start <= end){
            mid = start + ((end - start) >> 1);
            x = mid * mid;
            if (x >= num){
                if (x == num){
                    return true;
                }
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return false;
    }
}
