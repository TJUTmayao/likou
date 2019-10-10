package other;

import java.util.List;

/**
 * @ClassName Inner
 * @Description 测试内部类
 * @Author 11432
 * @DATE 2019/9/1 18:42
 */
public class Inner {
    private final static String staticVar = "常量";
    private String typeVer = "实例变量";
    public static String staticString = "类变量";
    public static void main(String[] args) {

    }
    public void outerMethodA(){
        System.out.println("外部类实例方法");
    }
    public static void outerMethodB(){
        System.out.println("外部类类方法");
    }

    /** ---------------------------------------------局部内部类，不可有类变量/方法-------------------------------- */
    public void localInner(){
        class localInner{
            public int B = 2;
            private static final int A = 100;
            public localInner(int a) {
                B = a;
            }
            public void methodB(){
                // 访问外部类实例变量
                System.out.println("静态内部类实例方法  访问外部类：" + new Inner().typeVer);
                // 访问外部类类变量
                System.out.println("静态内部类静态方法  访问外部类：" + staticString);
                // 访问外部类常量
                System.out.println("静态内部类静态方法  访问外部类：" + staticVar);
            }
        }
    }
    /** ---------------------------------------------------匿名内部类-------------------------------------------------------*/
    interface AnonymousInnerInterface{
        public void say();
    }
    public void anonymousInner(){
        AnonymousInnerInterface innerInterface = new AnonymousInnerInterface() {
            @Override
            public void say() {
                System.out.println("say hello");
            }
        };
    }
    /** ----------------------------------------------------静态内部类（属于类）--------------------------------------------- */
    public static class StaticInner{
        public static int A = 10;
        public int B = 2;

        public StaticInner(int b) {
            B = b;
        }

        public static void methodA(){
            // 访问外部类实例变量
            System.out.println("静态内部类实例方法  访问外部类：" + new Inner().typeVer);
            // 访问外部类类变量
            System.out.println("静态内部类静态方法  访问外部类：" + staticString);
            // 访问外部类常量
            System.out.println("静态内部类静态方法  访问外部类：" + staticVar);
            // 调用外部类类方法
            outerMethodB();
            // 调用外部类实例方法
            new Inner().outerMethodA();
        }
        public void methodB(){
            // 访问外部类实例变量
            System.out.println("静态内部类实例方法  访问外部类：" + new Inner().typeVer);
            // 访问外部类类变量
            System.out.println("静态内部类静态方法  访问外部类：" + staticString);
            // 访问外部类常量
            System.out.println("静态内部类静态方法  访问外部类：" + staticVar);
        }
    }
    /** ----------------------------------------------------成员内部类（属于实例对象）--------------------------------------------- */
    public class MemberInner{
        /** 不能有类变量和类方法，可以有常量 */
        private static final int A = 100;
//        public static int A = 10;
        public int B = 2;

        public MemberInner(int b) {
            B = b;
        }
//        public static void methodA(){}
        public void methodB(){
            // 访问外部类实例变量（可以直接访问）
            System.out.println("静态内部类实例方法  访问外部类：" + typeVer);
            // 访问外部类类变量
            System.out.println("静态内部类静态方法  访问外部类：" + staticString);
            // 访问外部类常量
            System.out.println("静态内部类静态方法  访问外部类：" + staticVar);
            // 调用外部类类方法
            outerMethodB();
            // 调用外部类实例方法（可以直接调用）
            outerMethodA();
        }
    }
}
