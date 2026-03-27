package day04_Operator.operator;

public class OperatorDemo2 {
    public static void main(String[] args) {
        // 2026年3月27日，今天学习运算符Operator的全部内容
        /*
        1.单独使用没有区别：
        int a = 10;
        ++a;
        a++

        2.参与运算使用
            ++在前：先自增再操作， ++a,a先自增再赋值
            ++在后：先操作再自增， c++,c先赋值再自增
        ps:自增自减，只能操作变量，不能操作字面量
         */
        int a = 10;
        int b = ++a;    // a = 11, b = 11
        System.out.println(a);
        System.out.println(b);

        int c = 10;
        int d =  c++;   // c = 11,d = 10
        System.out.println(c);
        System.out.println(d);

    }
}
