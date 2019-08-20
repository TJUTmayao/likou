package other;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxy
 * @Description 简单 动态代理
 * @Author 11432
 * @DATE 2019/8/17 14:18
 */
public class DynamicProxy {
    /** 接口 */
    interface Say{
        void sayHello();
    }
    /** 实现类 */
    static class SayHello implements Say{
        @Override
        public void sayHello() {
            System.out.println("hello world");
        }
    }
    /** 动态代理类 */
    static class MyProxy implements InvocationHandler{
        /** 被代理的对象 */
        private Object beiDaiLi;

        Object bind(Object beiDaiLi){
            this.beiDaiLi = beiDaiLi;
            Class<?> clazz = beiDaiLi.getClass();
            //  生成一个临时的代理类 并使用 被代理类的类加载器、其实现的接口以及代理逻辑（需要执行的额外操作） 创建一个代理对象。
            //  将InvocationHandler的实例组合到Proxy中，在调用Proxy对象的方法，实际上是调用InvocationHandler实例的invoke(Object,Method ,Object[])方法
            return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 代理逻辑
            System.out.print("代理 :");
            // 执行目标方法 ，需要 被代理对象及参数
            Object invoke = method.invoke(beiDaiLi, args);
            // 代理逻辑
            // 返回被代理方法的返回值
            return invoke;
        }
    }

    public static void main(String[] args) {
        Say bind =(Say) new MyProxy().bind(new SayHello());
        bind.sayHello();
    }


}