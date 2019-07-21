package easy;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/7 19:39
 */
public class Main {
    private static final long _1M = 1024 * 1024;

    private static char c;
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
//        boolean isOk = 1 > 2;
//        assert isOk : "断言打印";
//        System.out.println("正常执行 ");

        /** jvm从启动，到执行main里面的第一条代码，要经历很多的，比如加载rt.jar里面所有的Class，
         * 加载一个class肯定要执行static{}中内容，况且rt.jar中的jdk的类里面有很多xxx.startWith("java")
         * 或者其他用到"java"的代码，jvm启动的时候直接按照常量加载进来 */
//        String string1 = new StringBuilder("ja").append("va").toString();
//        System.out.println(string1 == string1.intern());
//
//        String string2 = new StringBuilder("aa").append("bb").toString();
//        System.out.println(string2 == string2.intern());

//        /** 直接内存溢出 */
//        Field field = Unsafe.class.getDeclaredFields()[0];
//        field.setAccessible(true);
//        try {
//            Unsafe unsafe = (Unsafe) field.get(null);
//            while (true){
//                unsafe.allocateMemory(_1M);
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        System.out.println(Integer.MAX_VALUE );
        int s = 1;
        for (int i = 0; i < 50; i++) {
            s *= 4;
            System.out.println(s);
        }
    }
}
