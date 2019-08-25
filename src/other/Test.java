package other;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 11432
 * @DATE 2019/8/24 14:02
 */
public class Test {
    public static void main(String[] args) {
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
}
