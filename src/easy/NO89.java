package easy;

/**
 * @ClassName NO89
 * @Description 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * @Author 11432
 * @DATE 2019/7/27 14:09
 */
public class NO89 {
    public static void main(String[] args) {
        System.out.println(addStrings("6","2"));
    }
    public static String addStrings(String num1, String num2) {
        String s;
        int carry = 0;
        int i,j,x;
        if (num1.length() < num2.length()){
            s = num1;
            num1 = num2;
            num2 = s;
        }
        char[] res = new char[num1.length()];
        int k = res.length - 1;
        for (i = num1.length() - 1,j = num2.length() - 1; i >= 0 ;i--,j--) {
            if (j >= 0){
                x = num1.charAt(i) + num2.charAt(j) - 96 + carry;
            }else {
                x = num1.charAt(i) - 48 + carry;
            }
            if (x > 9){
                x = x - 10;
                carry = 1;
            }else {
                carry = 0;
            }
            res[k--] = (char) (x + '0');
        }
        if (carry == 1){
            return "1" + new String(res);
        }
        return new String(res);
    }
}
