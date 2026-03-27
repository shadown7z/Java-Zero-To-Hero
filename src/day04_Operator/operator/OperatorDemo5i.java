package day04_Operator.operator;

public class OperatorDemo5i {
    public static void main(String[] args) {
        /*
        逻辑运算符（逻辑计算返回true或false）：把多个条件放在一起运算，最终返回true或者是false

        分类：
        &（与）：遇false则false
        |（或）：遇true 则true
        !（非）：取反
        ^（异或）：相同为false，不同为true
         */
        System.out.println(true & false); //只要有一个是false，那就返回false
        System.out.println(false & true);
        System.out.println(false & false);
        System.out.println(true & true);
        System.out.println("---------------------");
        System.out.println(true | false); //只要有一个是true，那就返回true
        System.out.println(false | true);
        System.out.println(false | false);
        System.out.println(true | true);
        System.out.println("---------------------");
        System.out.println(!false); //取反
        System.out.println(!true);
        System.out.println("---------------------");
        System.out.println(true ^ false); //不同为true，相同为false
        System.out.println(false ^ true);
        System.out.println(false ^ false);
        System.out.println(true ^ true);
    }
}
