package easy;

/**
 * @ClassName NO95
 * @Description 给定一组字符，使用原地算法将其压缩。
 *
 * 压缩后的长度必须始终小于或等于原数组长度。
 *
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 *
 * 在完成原地修改输入数组后，返回数组的新长度。
 * @Author 11432
 * @DATE 2019/7/30 15:44
 */
public class NO95 {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }
    public static int compress(char[] chars) {
        int num = 0;
        char last = chars[0];
        int j = 0;
        for (int i = 0;i < chars.length;) {
            if (last != chars[i]){
                chars[j++] = last;
                if (num > 1){
                    for (char c : String.valueOf(num).toCharArray()) {
                        chars[j ++] = c;
                    }
                }
                num = 1;
            }else if (last == chars[i]){
                num ++;
            }
            last = chars[i++];
        }
        chars[j++] = last;
        if (num > 1){
            for (char c : String.valueOf(num).toCharArray()) {
                chars[j ++] = c;
            }
        }
        return j;
    }
}
