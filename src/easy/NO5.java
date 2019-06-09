package easy;

/**
 * @ClassName NO5
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/8 16:28
 */
public class NO5 {

    public static void main(String[] args) {
        System.out.println(getCommonPrefix2(new String[]{"flower","flow","flight"}));
    }


    /** 正常版 */
    public static String getCommonPrefix(String[] strs){
        if (strs.length == 0){
            return "";
        }
        char[] chars = strs[0].toCharArray();
        int commonIndex = chars.length - 1;
        if (commonIndex < 0){
            return "";
        }
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (commonIndex > str.length() - 1){
                commonIndex = str.length() - 1;
            }
            for (int j = 0; j <= commonIndex; j++) {
                if (chars[j] != str.charAt(j)){
                    commonIndex = j - 1;
                    break;
                }
            }
        }
        return strs[0].substring(0,commonIndex + 1);
    }

    /** 提速版 */
    public static String getCommonPrefix2(String[] strs){
        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        if (prefix.isEmpty()){
            return "";
        }
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            for (;!str.startsWith(prefix);){
                prefix = prefix.substring(0,prefix.length() - 1);
                if (prefix.isEmpty()){return "";}
            }
        }
        return prefix;
    }
}
