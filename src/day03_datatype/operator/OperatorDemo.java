package day03_datatype.operator;

public class OperatorDemo {
    public static void main(String[] args) {
        //算术运算符 + - / %
        // `/`整除 ，`%` 是取余

        // 数值拆分案例:
        System.out.println("整数123的个位为："+123%10);
        System.out.println("整数123的十位为："+123/10%10);
        System.out.println("整数123的百位为："+123/10/10%10);

    }
}
