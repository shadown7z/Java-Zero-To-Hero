package day06_PrecessControl;

public class MarkDemo1 {
    public static void main(String[] args) {
        // lo，一键跳出多层嵌套
        lo:
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (j == 2) {
                    break lo;
                }
                System.out.println("HelloWorld");
            }
        }
    }
}
