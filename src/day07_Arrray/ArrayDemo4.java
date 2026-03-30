package day07_Arrray;

public class ArrayDemo4 {
    public static void main(String[] args) {
        /*
        动态初始化：初始化时只指定数组长度，由系统为数组分配初始值
        String初始值为null
         */
        String[] arr = new String[3];

        for(int i = 0 ; i <arr.length ; i++){
            System.out.println(arr[i]);
        }
    }
}
