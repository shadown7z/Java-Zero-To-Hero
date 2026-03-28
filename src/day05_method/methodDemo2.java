package day05_method;

public class methodDemo2 {
    public static void main(String[] args) {
        /*
        方法重载：
        同一个类中，方法名相同，参数不同，可以调用
        参数不同：个数不同，类型不同，顺序不同
         */
        add(10,100);
        add(7.31,2.34);


    }
    public static void add(int a, int b) {
        System.out.println(a + b);
    }
    public static void add(double a, double b) {
        System.out.println(a + b);
    }
}
