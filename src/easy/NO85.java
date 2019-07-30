package easy;

/**
 * @ClassName NO85
 * @Description 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * @Author 11432
 * @DATE 2019/7/26 10:08
 */
public class NO85 {
    public static void main(String[] args) {
        NO85 no85 = new NO85();
        System.out.println(no85.toHex(26));
    }
    public String toHex(int num) {
        if (num == 0){
            return "0";
        }
        String string = "";
        for (int i = 0; i < 32 && num != 0; i += 4) {
            String s = get16(num & 15);
            string = s + string;
            num = num >> 4;
        }
        return string;
    }
    public String get16(int n){
        if (n >= 0 && n <= 9){
            return n + "";
        }
        switch (n){
            case 10:
                return "a";
            case 11:
                return "b";
            case 12:
                return "c";
            case 13:
                return "d";
            case 14:
                return "e";
                default:
                    return "f";
        }
    }
}
