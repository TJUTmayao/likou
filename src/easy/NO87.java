package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NO87
 * @Description 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * @Author 11432
 * @DATE 2019/7/26 16:17
 */
public class NO87 {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0){
                list.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0){
                list.add("Fizz");continue;
            }else if (i % 5 == 0){
                list.add("Buzz");continue;
            }
            list.add(i + "");
        }
        return list;
    }

    public List<String> fizzBuzz2(int n) {
        ArrayList<String> list = new ArrayList<>();
        String s;
        for (int i = 1; i <= n; i++) {
            s = "";
            if (i % 3 == 0){
                s += "Fizz";
            }
            if (i % 5 == 0){
                s += "Buzz";
            }
            if (s == ""){
                s += i;
            }
            list.add(s);
        }
        return list;
    }
}
