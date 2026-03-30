package day07_Arrray;

public class ArrayDemo2 {
    public static void main(String[] args) {
        /*
            数组的元素访问：    数组名[索引]
            索引（角标，下标）：索引是数组容器中空间的编号，编号从0开始，
         */
        int[] arr = {11,22,33,44,55 };

        // 取出22元素并打印
        System.out.println(arr[1]);
        //修改数组第1个元素为66
        arr[0] = 66;
        System.out.println(arr[0]);
        // 判断数组中的第3个元素是奇数还是偶数
        if (arr[2] % 2 == 0){
            System.out.println(arr[2]+"是一个偶数");
        } else {
            System.out.println(arr[2]+"是一个奇数");
        }
        // 根据数组中的最后一个元素，来决定在控制台打印多少次HelloWorld
        for (int i = 1;i<= arr[arr.length-1]; i++){
            System.out.println("这是第"+i+"次的HelloWorld");
        }
        System.out.println(arr.length-1);
    }
}
