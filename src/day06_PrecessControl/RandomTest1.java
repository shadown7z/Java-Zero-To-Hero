package day06_PrecessControl;

import java.util.Random;
import java.util.Scanner;

public class RandomTest1 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int randomNumber = r.nextInt(100)+1;

        while (true){
            System.out.println("请输入：");
            int inputNumber = sc.nextInt();
            if(inputNumber>randomNumber){
                System.out.println("猜大了");
            }else if(inputNumber<randomNumber){
                System.out.println("猜小了");
            } else{
                System.out.println("恭喜，猜中了！");
                break;
            }
        }
    }
}
