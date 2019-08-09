package easy;

/**
 * @ClassName NO105
 * @Description 给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。N 个 '-' 将字符串分成了 N+1 组。
 * 给定一个数字 K，重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符，第一个分组至少要包含 1 个字符。
 * 两个分组之间用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 *
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 *
 * @Author 11432
 * @DATE 2019/8/5 9:41
 */
public class NO105 {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("2-4A0r7-4kff"
               , 4));
    }
    public static String licenseKeyFormatting(String S, int K) {
        int i,j;
        StringBuilder builder = new StringBuilder();
        for (i = 0,j = 0; i < S.length() && j < S.length();j++) {
            if (S.charAt(j) != '-') {
                i++;
            }
        }
        i = i % K;
        if (i > S.length() || i == 0){
            i = K;
        }
        int num = 0;
        for (int k = 0; k < S.length(); k++) {
            char c = S.charAt(k);
            if (c != '-'){
                if (c > 90){
                    c = (char)(c - 32);
                }
                if (num >= K || num >= i){
                    num = 1;
                    i = K;
                    builder.append('-');
                }else {
                    num ++;
                }
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
