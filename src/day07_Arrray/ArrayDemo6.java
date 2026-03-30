package day07_Arrray;

public class ArrayDemo6 {
    public static void main(String[] args) {
        /*
        二维数组: 一种容器, 内部存储的都是一维数组

        定义格式:
                    数据类型[][] 数组名 = new 数据类型[][]{ {一维数组元素}, {一维数组元素} };
                    数据类型[][] 数组名 = { {一维数组元素}, {一维数组元素} };

        元素访问格式:
                    数组名[索引][索引];
         */
        int[][] arr = {
                {11,22,33},
                {44,55,66}
        };

        System.out.println(arr);
        System.out.println(arr[0][2]);
        System.out.println(arr[1][1]);
    }
}
