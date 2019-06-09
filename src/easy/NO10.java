package easy;

import Utils.ArrayUtil;

import java.util.Map;

/**
 * @ClassName NO10
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/9 9:34
 */
public class NO10 {

    public static void main(String[] args) {
        System.out.println(KMP("ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb",
                "abbabbbabaa"));

//        String string =  "ababbbbabaa";
//        ArrayUtil.showInts(getSubprefix(string.toCharArray(),string.length()));
//        ArrayUtil.showInts(getNexts(string.toCharArray(),string.length()));
//        System.out.println();

//        System.out.println(getBadChar(string.toCharArray(),0,"aaa".toCharArray(),0));
    }
    public static int indexOf(String haystack, String needle){
        if (needle == null || "".equals(needle)){
            return 0;
        }
        int matchSize = 0;
        int nextIndex = -1;
        char[] chars = haystack.toCharArray();
        char[] target = needle.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            if (nextIndex == -1 && matchSize != 0){
                if (chars[i] == target[0]){
                    nextIndex = i;
                }
            }
            if (chars[i] == target[matchSize]){
                matchSize ++;
                if (matchSize == needle.length()){
                    return i - matchSize + 1;
                }
            }
            else if (chars[i] != target[matchSize]){
                if (nextIndex != -1){
                    i = nextIndex - 1;
                    nextIndex = -1;
                }
                matchSize = 0;
            }
            if (matchSize == 0 && chars.length - i < target.length){
                return -1;
            }
        }
        return -1;
    }


    /** --------------------------------------------KMP 算法-------------------------------------------------- */

    /** 获取匹配串的最大可匹配前缀下标的索引表——失效函数 */
    private static int[] getSubprefix(char[] target,int size){
        int[] maxSubprefix = new int[size + 1];
        //初始化
        for (int i = 0; i <= size; i++) {
            maxSubprefix[i] = -1;
        }
        for (int i = 2; i <= size; i++) {
            int lastIndex = maxSubprefix[i - 1];
            while (lastIndex != -1){
                if (target[lastIndex + 1] == target[i - 1]){
                    break;
                }
                // 因为[0,i-1]的前缀子串与后缀子串相同，因此找到 该前缀子串 的最大可匹配前缀子串S，S的最大前缀子串和最大后缀子串，就一定是S
                // 所对应的后缀子串S'的最大前缀子串和最大后缀子串，即S的最大前缀子串和S'的最大后缀子串就是次长可匹配前缀和后缀子串。
                lastIndex = maxSubprefix[lastIndex + 1];
            }
            if (i - 1 != lastIndex + 1 && target[lastIndex + 1] == target[i - 1]){
                maxSubprefix[i] = lastIndex + 1;
            }
        }
        return maxSubprefix;
    }

    /** 获取坏前缀的位置  -1代表没有找到坏字符 */
    private static int getBadChar(char[] source,int start,char[] target,int start2){
        if (start < 0){start = 0;}
        for (int i = start,j = start2; j < target.length && i < source.length; i++,j++) {
            if (source[i] != target[j]){
                return j;
            }
        }
        return -1;
    }

    private static int KMP(String source,String target){
        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();
        int badIndex;
        int targetSize = targetChars.length;
        int reStartT = 0;
        int moveLength;
        //获取所有最大可匹配前缀子串  失效函数
        int[] subprefix = getSubprefix(targetChars, targetSize);
        //遍历主串
        for (int i = 0; i <= sourceChars.length - targetSize;) {
            //获取坏字符の下标，即好前缀的长度
            badIndex = getBadChar(sourceChars,i + reStartT,targetChars,reStartT);
            if (badIndex == -1){
                return i;
            }else {
                //获取最大可匹配前缀子串的下标
                int prefixIndex = subprefix[badIndex];
                //获取移动到 与前缀子串匹配的后缀子串 时需要移动的距离
                if (prefixIndex == -1){
                    moveLength = badIndex == 0 ? 1 : badIndex;
                    reStartT = 0;
                }else {
                    moveLength = badIndex - prefixIndex - 1 ;
                    reStartT = prefixIndex + 1;
                }
                //直接将匹配串移动 moveLength
                i += moveLength;
            }
        }
        return -1;
    }



    /** 参考 失效函数构造 */
    // b 表示模式串，m 表示模式串的长度
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

}
