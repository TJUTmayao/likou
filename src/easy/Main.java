package easy;

import java.util.ArrayList;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/7 19:39
 */
public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(22);
//        for (int i = 1; i < 4; i++) {
//            integers.add(integers.size() - 1,i);
//        }
//        integers.forEach(aInt -> System.out.println(aInt));
//        System.out.println('a' - 'A');\

        /** 断言测试 */
//        boolean isOpen = false;
//
//        // 如果开启了断言，会将isOpen的值改为true
//        assert isOpen = true;
//
//        // 打印是否开启了断言，如果为false，则没有启用断言
//        System.out.println(isOpen);
        boolean isOk = 1 > 2;
        assert isOk : "断言打印";
        System.out.println("正常执行 ");
    }
}
