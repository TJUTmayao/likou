package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NO63
 * @Description 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * @Author 11432
 * @DATE 2019/7/18 17:55
 */
public class NO63 {

    public int addDigits(int num) {
        while (num >= 10){
            num = getInts(num);
        }
        return num;
    }

    public int getInts(int n){
        int x = 0;
        while (n != 0){
            x += n % 10;
            n /= 10;
        }
        return x;
    }
}
