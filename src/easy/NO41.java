package easy;

/**
 * @ClassName NO41
 * @Description 给定一个Excel表格中的列名称，返回其相应的列序号。
 * @Author 11432
 * @DATE 2019/7/12 18:48
 */
public class NO41 {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + s.charAt(i) - 64;
        }
        return result;
    }
}
