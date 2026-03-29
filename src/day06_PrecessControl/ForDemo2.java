package day06_PrecessControl;

public class ForDemo2 {
    // 99乘法表
    public static void main(String[] args) {
        //外层循环：控制行数（i代表当前是第几行）
        for (int i = 1; i <= 9; i++){
            // 内层循环：控制每行的列数（j必须小于等于i)
            for (int j = 1 ; j <= i ; j++){
                //打印乘法等式，使用\t(制表符)保证对齐
                System.out.print(j + "*" + i + "="+ (i*j)+"\t");
            }
            // 每一行结束后换行
            System.out.println();
        }
    }
}
