package easy;

/**
 * @ClassName NO111
 * @Description 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * @Author 11432
 * @DATE 2019/8/6 17:35
 */
public class NO111 {

    public static void main(String[] args) {
        System.out.println(convertToBase7(-77));
    }
    public static String convertToBase7(int num) {
        if (num == 0){
            return "0";
        }
        String res = "";
        int x = num;
        num = Math.abs(num);
        while (num != 0){
            res = num % 7 + res;
            num /= 7;
        }
        return x >= 0 ? res : "-" + res;
    }
}
