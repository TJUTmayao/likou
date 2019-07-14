package easy;

import java.util.ArrayList;

/**
 * @ClassName NO44
 * @Description 颠倒给定的 32 位无符号整数的二进制位。
 * @Author 11432
 * @DATE 2019/7/14 12:03
 */
public class NO44 {

    public static void main(String[] args) {
        System.out.println(reverseBits1(-3));
    }
    /** 暴力法 */
    public static int reverseBits(int n) {
        ArrayList<Integer> integers = new ArrayList<>();
        while (n != 0){
            integers.add(n % 2);
            n = n / 2;
        }
        while (integers.size() < 31){
            integers.add(0);
        }
        if (n >= 0){
            integers.add(0);
        }else {
            integers.add(1);
        }
        int result = 0;
        for (Integer integer : integers) {
            result = (result << 1) + integer;
        }
        return result;
    }

    public static int reverseBits1(int n) {
        int result = 0;
        for (int i = 0; i <= 32; i++) {
            // 1. 将给定的二进制数,由低到高位逐个取出
            // 1.1 右移 i 位,
            int tmp = n >> i;
            // 1.2  取有效位.去除符号位影响
            tmp = tmp & 1;
            // 2. 然后通过位运算将其放置到反转后的位置.
            tmp = tmp << (31 - i);
            // 3. 将上述结果再次通过运算结合到一起
            result |= tmp;
        }
        return result;
    }
}
