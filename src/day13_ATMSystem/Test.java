package day13_ATMSystem;

import day09_ObjectBasic.permission.demo.A;

public class Test {
    public static void main(String[] args){
        // 目标：完成ATM系统
        // 1.创建一个ATM对象代表一个ATM机
        ATM atm = new ATM();
        // 2. 把ATM启动自动（开机）
        atm.start();
    }
}
