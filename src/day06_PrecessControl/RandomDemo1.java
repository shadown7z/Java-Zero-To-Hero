package day06_PrecessControl;

import java.util.Random;

public class RandomDemo1 {
    public static void main(String[] args) {
        Random r =  new Random();

        for (int i =0;i<=10;i++){
            int num = r.nextInt(100)+1;
            System.out.println(num);
        }
    }
}
