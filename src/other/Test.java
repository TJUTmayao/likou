package other;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 11432
 * @DATE 2019/8/24 14:02
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.test2();
    }
    /** 自动装箱、拆箱陷阱 */
    public void test1(){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 128;
        Integer f = 123;
        Long g = 3L;
        // Integer储存一个【-128,127】的常量池，因此c和d为同一个对象
        System.out.println(c == d);
        // 同上，e，f为不同对象
        System.out.println(e == f);
        // + 号为算数运算符，a和b自动拆箱为int，其结果也为int，因此c也自动拆箱为int
        System.out.println(c == (a + b));
        // equals方法先比较两者的类型，然后才会比较值，所以为true
        System.out.println(c.equals(a + b));
        // + 号为算数运算符，a和b自动拆箱为int，其结果也为int，因此g也自动拆箱为long
        System.out.println(g == (a + b));
        // equals方法先比较两者的类型，Long与Integer为不同类型
        System.out.println(g.equals(a + b));
    }
    /** codePoint测试 */
    public void test2(){
        String string = "a";
        // 返回指定字符的编码值
        int i = string.codePointAt(0);
        System.out.println(i);
        Character character = '汉';
        // 返回指定字符数组的指定下标的字符的编码值
        System.out.println(Character.codePointAt(new char[]{'a','v'},1,2));
        // 获取指定编码值占几个 char（一个char的编码范围0~65535）
        System.out.println(Character.charCount(65536));
        // 是否是数字
        System.out.println(Character.isDigit('*'));
    }

    public interface A{
        int A = 0;
        public final int B = 0;
        public static int C =3;

        public static Void V(){
            return null;
        }
    }
}
