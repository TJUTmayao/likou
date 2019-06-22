package easy;

import java.util.ArrayList;

/**
 * @ClassName NO12
 * @Description 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * @Author 11432
 * @DATE 2019/6/22 8:18
 */
public class NO12 {

    public static void main(String[] args) {
        System.out.println(countAndSay("1",1));
    }

//    public static String countAndSay(int n){
////        //统计相同字符个数
////        int count = 0;
////        String string = "1";
////        for (int i = 2; i <= n; i++) {
////            StringBuilder builder = new StringBuilder();
////            //交换指针
////            //统计
////            for (int j = 0; j < string.length(); j++) {
////                char aChar = string.charAt(j);
////                count += 1;
////                if (j == string.length() - 1 || aChar != string.charAt(j + 1)){
////                    builder.append(count).append(aChar);
////                    count = 0;
////                }
////            }
////            string = builder.toString();
////        }
////        return string;
//    }

    /** 递归版 */
    public static String countAndSay(String string ,int n){
        if (n == 1){
            return string;
        }
        char[] chars = string.toCharArray();
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < string.length(); j++) {
            count += 1;
            if (j == string.length() - 1 || chars[j] != chars[j + 1]){
                builder.append(count).append(chars[j]);
                count = 0;
            }
        }
        string = builder.toString();
        if (n - 2 > 0){
            return countAndSay(string,n - 1);
        }
        return string;
    }
}
