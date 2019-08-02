package easy;

/**
 * @ClassName NO100
 * @Description 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * @Author 11432
 * @DATE 2019/8/2 17:27
 */
public class NO100 {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("aba"));
    }
    public static boolean repeatedSubstringPattern(String s) {
        int k,j;
        int size = s.length() / 2;
        int length = s.length();
        for (int i = 1; i <= size; i++) {
            if (length % i == 0){
                k = 0;
                j = 0;
                while (j < length && s.charAt(k) == s.charAt(j)){
                    k ++;
                    j ++;
                    if (k == i){
                        k = 0;
                    }
                }
                if (j == length){
                    return true;
                }
            }
        }
        return false;
    }

    /** 极简版 */
    public static boolean repeatedSubstringPattern2(String s) {
        int l,k;
        int size = s.length() / 2;
        int length = s.length();
        for (int i = 1; i <= size; i++) {
            if (length % i == 0){
                k = 0;
                for (l = 0; l < length && s.charAt(k) == s.charAt(l); l++) {
                    k ++;
                    if (k == i){
                        k = 0;
                    }
                }
                if (l == length){
                    return true;
                }
            }
        }
        return false;
    }
}
