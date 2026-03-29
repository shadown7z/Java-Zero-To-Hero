package day06_PrecessControl;

import java.util.Scanner;

public class IfTest_Start {
    public static void main(String[] args) {
        // 2026年3月29日，今天学习流程控制语句
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的成绩：");
        int score = sc.nextInt();
        checkScore(score);

    }
    public static void checkScore(int score) {
        if (score >= 0 && score <= 100){
            // 进一步判断
            if (score >= 95){
                //打印对应奖励
                System.out.println("奖励5090显卡一张");
            } else if (score >= 85){
                System.out.println("奖励一个赛博朋克2077");
            } else if (score >= 75){
                System.out.println("奖励一个我的世界正版");
            } else {
                System.out.println("爱的教育");
            }
        } else {
            //给出错误提示
            System.out.println("您输入的分数有误，请检查！");
        }
    }
}
