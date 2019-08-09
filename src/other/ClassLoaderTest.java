package other;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName ClassLoaderTest
 * @Description classLoader测试
 * @Author 11432
 * @DATE 2019/8/9 13:58
 */
public class ClassLoaderTest extends ClassLoader{

    public static void main(String[] args) throws Exception{
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        classLoaderTest.loadClass("E:\\IDEA_Project\\likou\\src\\Test.java");
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        // 查找是否已加载
        Class<?> c = findLoadedClass(name);
        if (c == null){
            // 交给ApplicationClassLoader加载,根据双亲委托将加载请求传递给ExtensionClassLoader及（BootStrap）引导类加载器。
            c = getParent().loadClass(name);
            if (c == null){
                // 自己加载
                try {
                    InputStream in = getResourceAsStream(name);
                    byte[] bytes = new byte[in.available()];
                    in.read(bytes);
                    return defineClass(name,bytes,0,bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return c;
    }
}
