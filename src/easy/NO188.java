package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NO188
 * @Description 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 * @Author 11432
 * @DATE 2019/8/31 16:22
 */
public class NO188 {
    public static void main(String[] args) {
        NO188 no188 = new NO188();
        int[] ints = no188.shortestToChar2("loveleetcode", 'e');
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }
    }
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        int x = 0;
        int y = -10001;
        while (x < S.length() && S.charAt(x) != C){
            x ++;
        }
        for (int i = 0; i < S.length(); i++) {
            if (x <= i){
                y = x++;
                while (x < S.length() && S.charAt(x)!= C){
                    x ++;
                }
            }
            if (x == S.length()){
                res[i] = i - y;
            }else {
                res[i] = Math.min(x - i,i - y);
            }
        }
        return res;
    }

    public int[] shortestToChar2(String S, char C) {
        int[] res = new int[S.length()];
        int indexC = -10000;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C){
                indexC = i;
            }
            res[i] = i - indexC;
        }
        for (int i = indexC; i >= 0; i--) {
            if (S.charAt(i) == C){
                indexC = i;
            }
            res[i] = Math.min(res[i],indexC - i);
        }
        return res;
    }
}
