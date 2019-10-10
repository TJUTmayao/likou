package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName NO185
 * @Description 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，
 *
 * 最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
 *
 * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 *
 * 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subdomain-visit-count
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/31 14:54
 */
public class NO185 {
    public static void main(String[] args) {
        List<String> strings = subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
        for (String string : strings) {
            System.out.println(string);
        }
    }
    public static List<String> subdomainVisits(String[] cpdomains) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : cpdomains) {
            int x = str.indexOf(" ");
            int num = Integer.valueOf(str.substring(0,x));
            do {
                String substring = str.substring(x + 1);
                Integer integer = map.get(substring);
                if (integer == null){
                    map.put(substring,num);
                }else {
                    map.put(substring,num + integer);
                }
            }while ((x = str.indexOf(".",x + 1)) != -1);
        }
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}
