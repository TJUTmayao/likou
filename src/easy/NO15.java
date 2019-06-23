package easy;

/**
 * @ClassName NO15
 * @Description 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @Author 11432
 * @DATE 2019/6/23 8:55
 */
public class NO15 {

    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{9, 9, 9, 9, 9, 9});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "\t");
        }
    }

    /* 范用 */
    public static int[] plusOne(int[] digits) {
        int num = 1,newNum;
        int i;
        for (i = digits.length - 1; i >=0 ; i --) {
            newNum = digits[i] + num;
            num = newNum / 10;
            digits[i] = newNum % 10;
            if (num == 0){return digits;}
        }
        int[] addOne = new int[digits.length + 1];
        addOne[0] = 1;
        return addOne;
    }

    /* */
    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >=0 ; i --) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0){return digits;}
        }
        int[] addOne = new int[digits.length + 1];
        addOne[0] = 1;
        return addOne;
    }
}
