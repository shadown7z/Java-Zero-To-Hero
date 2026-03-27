package day04_Operator.operator;

public class OperatorDemo6i {
    /*
        短路逻辑运算符（执行与执行哪边）:
            & : 没有短路效果, 无论符号左边是true还是false, 右边都要继续执行.
            && : 具有短路效果, 当符号左边为false的时候, 右边就不执行了.
                    如果符号左边为true, 右边要继续执行.

            | : 没有短路效果, 无论符号左边是true还是false, 右边都要继续执行.
            || : 具有短路效果, 当符号左边为true的时候, 右边就不执行了.
                    如果符号左边为false, 右边要继续执行.
     */
    public static void main(String[] args) {
        int x = 3;
        int y = 4;

        // false & false
        boolean result = ++x > 5 && y-- < 4;
        /*
        ++x，先自增再操作
        4 > 5 ，返回值为false，
        && ，左边为false直接短路，右边不执行
        因为右边 y-- < 4 没有被执行，所以整个表达式都是false，且y依然是4
         */

        System.out.println(result);     // false

        System.out.println(x);          // 4
        System.out.println(y);          // 4

    }
}
