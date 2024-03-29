package easy;

/**
 * @ClassName NO122
 * @Description 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 11432
 * @DATE 2019/8/9 17:49
 */
public class NO122 {
    public boolean checkRecord(String s) {
        int Anum = 0;
        int Lnum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L'){
                Lnum++;
                if (Lnum > 2){
                    return false;
                }
            }else {
                Lnum = 0;
                if (c == 'A'){
                    Anum ++;
                    if (Anum > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
