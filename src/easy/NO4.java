package easy;

import javax.swing.text.Keymap;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName NO4
 * @Description 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数
 * 等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * @Author 11432
 * @DATE 2019/6/8 14:43
 */
public class NO4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getInt("MCMXCIV"));
    }
    public static final HashMap<Character,Integer> MAP;
    static {
        MAP = new HashMap<>();
        MAP.put('I',1);
        MAP.put('V',5);
        MAP.put('X',10);
        MAP.put('L',50);
        MAP.put('C',100);
        MAP.put('D',500);
        MAP.put('M',1000);
    }

    /** switch-case 比HashMap快 */
    public static int getInt(String s){
        int last = s.length() - 1;
        int result = getValue(s.charAt(last));
        for (int i = last - 1; i >= 0; i--) {
            char aChar = s.charAt(i);
            char thisChar = s.charAt(last);
            last = i;
            if (aChar == 'I'){
                if (thisChar == 'V' || thisChar == 'X'){
                    result -= getValue(aChar);
                    continue;
                }
            }
            if (aChar == 'X'){
                if (thisChar == 'L' || thisChar == 'C'){
                    result -= getValue(aChar);
                    continue;
                }
            }
            if (aChar == 'C'){
                if (thisChar == 'D' || thisChar == 'M'){
                    result -= getValue(aChar);
                    continue;
                }
            }
            result += getValue(aChar);
        }
        return result;
    }

    private static int getValue(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            default:
                return 1000;
        }
    }
}
