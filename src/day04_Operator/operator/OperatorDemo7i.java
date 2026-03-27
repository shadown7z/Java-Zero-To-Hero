package day04_Operator.operator;

public class OperatorDemo7i {
    public static void main(String[] args) {
    /*
        格式:判断条件 ? 值1 : 值2;

        执行流程:
          首先计算 判断条件的值
          如果值为true, 值1 就是运算结果
          如果值为false, 值2 就是运算结果

        需求: 从两个变量中找出最大值
     */
     int a = 50;
     int b = 20;

     //a是否大于b，大于b返回a，否则返回b
     int max = a > b ? a : b;
     System.out.println("最大值为："+max);

    }
}
