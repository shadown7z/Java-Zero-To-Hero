package day07_Arrray;

public class ArrayDemo1_Start {
    public static void main(String[] args) {
        /*
        2026年3月30日今天学习了数组
        数组完整格式：
        数据类型[] 数组名 = new 数据类型[]{元素1, 元素2, 元素3};

        简化格式：
        数据类型[] 数组名 = {元素1，元素2，元素3}
         */
        int[] arr1 = new int[]{11,22,33};
        double[] arr2 = {11.1,22.2,33.3};

        //打印出来的不是数据，而是十六进制内层地址
        //             [I@10f87f48
        //            @ : 分隔符
        //            [ : 当前的空间是数组类型
        //            I : 数组中元素的类型
        System.out.println(arr1);
        System.out.println(arr2);
    }
}
