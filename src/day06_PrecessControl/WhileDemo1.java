package day06_PrecessControl;

public class WhileDemo1 {
    public static void main(String[] args) {
        for(int i = 1;i<=5;i++){
            System.out.println("HelloWorld");
        }
        System.out.println("----------------");

        int i = 1;
        while(i<=5){
            System.out.println("HelloWorld"+"这是第"+i+"次");
            i++;
        }
    }
}
