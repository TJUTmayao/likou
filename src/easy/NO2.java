package easy;

import java.awt.peer.LightweightPeer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName NO2
 * @Description 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。翻转后超出int范围，返回0
 * @Author 11432
 * @DATE 2019/6/8 8:27
 */
public class NO2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        System.out.println(getFlipNumber(target));
    }

    /** 借助辅助栈 */
    public static int getFlipNumber(int x){
        ArrayList<Integer> number = new ArrayList<>();
        int min = Integer.MIN_VALUE / 10;
        int max = Integer.MAX_VALUE / 10;
        int k;
        //将数的每一位放入栈中
        for (int i = x; i != 0;) {
            k = i % 10;
            number.add(k);
            i /= 10;
        }
        int result = 0;
        for (int i = 0 ;i < number.size(); i ++) {
            Integer num = number.get(i);
            if (result > max || result < min){
                return 0;
            }
            result = result * 10 + num;
        }
        return result;
    }


    /** 不借助辅助栈 */
    public static int getFlipNumber2(int x){
        int k,result;
        int min = Integer.MIN_VALUE / 10;
        int max = Integer.MAX_VALUE / 10;
        k = x;
        result = 0;
        for (;k != 0;){
            if (result > max || result < min){
                return 0;
            }
            result =  result * 10 + k % 10;
            k /= 10;
        }
        return result;
    }

}
