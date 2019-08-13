package other;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * @ClassName MethodHandleTest
 * @Description 简单测试java动态类型支持
 * @Author 11432
 * @DATE 2019/8/13 14:49
 */
public class MethodHandleTest {
    static class MyPrint{
        public void println(String s){
            System.out.println("MyPrintln--" + s);
        }
    }

    /** Object中并不包含 println 方法 ，但由于动态类型语言变量类型是由变量值在决定的，因此可以调用成功
     *  若是正常调用，在静态分派过程（编译阶段），会通过方法接收者的静态类型确定符号引用，而Object没有该方法，编译不通过
     *  疑惑：和反射的区别？
     * */
    public static void main(String[] args)throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? new MyPrint() : System.out;
        // invokeExact执行返回的方法
        getPrintMH(obj).invokeExact("执行");
        getM(obj).invoke(obj,"反射成功");
    }

    /** MethodHandle */
    public static MethodHandle getPrintMH(Object obj)throws Throwable{
        // 方法类型 = 方法返回类型 + 方法参数类型数组
        MethodType methodType = MethodType.methodType(void.class,String.class);
        // MethodHandles.lookup().findVirtual/findStatic... 方法：查找指定简单名称+方法描述符并且有访问权限的虚方法/类方法...
        // bindTo方法用于传递隐藏参数this。
        return MethodHandles.lookup().findVirtual(obj.getClass(),"println",methodType).bindTo(obj);
    }

    /** 反射 */
    public static Method getM(Object obj)throws Throwable{
        Class<?> clazz = obj.getClass();
        Method println = clazz.getDeclaredMethod("println", String.class);
        return println;
    }
}
