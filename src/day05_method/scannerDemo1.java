package day05_method;

import java.util.Scanner;

public class scannerDemo1 {
    public static void main(String[] args) {
        // 1. 导包
        // 2. 拿出来（写一个对象）
        // 3. 使用（使用这个对象）
        Scanner sc  = new Scanner(System.in);

        System.out.println("请输入您的年龄：");
        int age = sc.nextInt();

        System.out.println("请输入您的姓名：");
        String name = sc.next();

        System.out.println("姓名为"+name+','+"年龄为"+age);
    }
}
