package easy;

/**
 * @ClassName NO216
 * @Description 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/long-pressed-name
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/9/14 14:33
 */
public class NO216 {

    public static void main(String[] args) {
        System.out.println(isLongPressedName("vtkgn"
                ,"vttkgnn"));
    }
    public static boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length() && name.charAt(0) != typed.charAt(0)){
            return false;
        }
        int i = 1,j = 1;
        for (;j < typed.length(); j++) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)){
                i ++;
            }else {
                if (typed.charAt(j - 1) != typed.charAt(j)){
                    return false;
                }
            }
        }
        return j == typed.length() && i == name.length();
    }
}
