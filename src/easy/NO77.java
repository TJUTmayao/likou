package easy;

/**
 * @ClassName NO77
 * @Description 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * @Author 11432
 * @DATE 2019/7/21 16:52
 */
public class NO77 {
    /** 第一步 A^B 求无进位的加法结果
     *  第二步 A&B 求每一位相加后的进位
     *  第三步 <<1 将进位移动到正确的位置 这时难免会出现又要进位的情况，循环直到无进位*/
    public int getSum(int a, int b) {
        if(b==0){
            return a;
        }
        int s1 = a ^ b;
        int s2 = (a & b) << 1;
        return getSum(s1,s2);
    }
}
