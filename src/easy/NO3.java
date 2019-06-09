package easy;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/**
 * @ClassName NO3
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/8 10:38
 */
public class NO3 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1));
    }
    public static final int MAX = Integer.MAX_VALUE;
    public static final int MIN = Integer.MIN_VALUE;
    public static boolean isPalindrome(int x){
        if (x < 0 || (x % 10 == 0 && x > 0)){
            return false;
        }
        int k = x;
        int result = 0;
        for (;result < k;) {
            result = result * 10 + k % 10;
            k /= 10;
        }
        return result == k || result / 10 == k;
    }
}
