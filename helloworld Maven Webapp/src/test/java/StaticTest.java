/**
 * 测试：静态代码块、非静待代码块、静态变量的执行次序
 * @author TL
 *
 */
public class StaticTest {

    public static void main(String[] args) {
        staticFunction();
    }

//    static StaticTest st = new StaticTest();
    static {
        System.out.println("1");
    }
    {
        System.out.println("2");
    }

    public StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + " b=" + b);
    }

    private static void staticFunction() {
        System.out.println("4");
    }

    int a = 100;
    static int b = 112;

}