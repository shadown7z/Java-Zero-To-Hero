package day06_PrecessControl;

public class BreakDemo1 {
    public static void main(String[] args) {
        for (int i = 7; i <= 12; i++) {
            if (i == 10) {
                break;
            }
            System.out.println(i + "点正在学习");
        }
    }
}
