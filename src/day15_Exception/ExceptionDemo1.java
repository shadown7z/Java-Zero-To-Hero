package day15_Exception;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        int x = 101;
        System.out.println("开始了");
        try {
            save(x);
            System.out.println("执行成功了");
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常对象信息
            System.out.println("执行失败了");
        }
        System.out.println("结束了");
    }

    private static void save(int age) {

        if (age <= 0 || age > 100) {
            throw new ArithmeticException("/x is error");
        }
        System.out.println("年龄保存成功了，年龄是："+age);

    }

}
