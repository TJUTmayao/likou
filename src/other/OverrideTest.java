package other;

import java.io.Serializable;

/**
 * @ClassName OverrideTest
 * @Description byte --> short / char --> int --> long --> float --> double --> 对应包装类 --> 接口 --> 父类 --> 变长参数
 * @Author 11432
 * @DATE 2019/8/11 14:52
 */
public class OverrideTest {
    public void say(int x){
        System.out.println("int");
    }

//    public void say(char x){
//        System.out.println("char");
//    }

//    public void say(Character x){
//        System.out.println("Character");
//    }
//
//    public void say(Serializable x){
//        System.out.println("Serializable");
//    }

//    public void say(char... x){
//        System.out.println("char...");
//    }
//    public void say(int... x){
//        System.out.println("int...");
//    }
//    public void say(Character... x){
//        System.out.println("Character...");
//    }
//    public void say(Object... x){
//        System.out.println("Serializable...");
//    }

    public static void main(String[] args) {
        OverrideTest overrideTest = new OverrideTest();
        short c = 3;
        overrideTest.say(c);
    }

}
