package day08_ObjectBasic.mstatic;

public class StudentTest2 {
        /*
        static的注意事项:
            1. static中只能访问静态变量 (直接访问)
            2. static中没有this关键字
     */

    static int num = 10;

    public static void main(String[] args) {
        System.out.println(num);
        method();
    }

    public static void method() {
        System.out.println("method...");
    }
}
