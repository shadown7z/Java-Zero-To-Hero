package day05_method;

public class methodDemo1 {
    // 2026年3月28日今天学习了方法和scanner
    public static void main(String[] args) {
        // 方法格式 public static void 方法名(){方法体}
        //调用打印HelloWorld方法
        printHelloworld();

        // 带参数的方法，调用得到最大值方法（函数）
        getMax(10,30);
        //形参，定义方法时，定义的需求参数
        //实参，使用方法时，传入的实际参数

        // 带返回值的方法，
        int result = add(100,20);
        System.out.println(result);

        /*
            方法通用定义格式
            public static 返回值类型 方法名（参数）{
                方法体;
                return 数据；
            }
         */

        //计算两个小数的和
       double ln =  getlittlenumber(0.37,0.21);
       System.out.println(ln);

       // 计算3个整数的最小值
        int min11 =  min1(3,7,1);
        System.out.println(min11);



    }

    //一个普通的打印HelloWorld
    public static void printHelloworld(){
    System.out.println("hello world");
    }

    //带参数的方法
    public static void getMax(int num1,int num2){
        int max = num1 > num2 ? num1 : num2;
        System.out.println(max);
    }

    // 带返回值的方法，加一个`return 数据值;`就行
    public static int add(int a , int b){
        int c = a + b;
        return c;
    }
    public static double getNum(){
        return 12.3;
    }

    //计算2个小数的和
    public static double getlittlenumber(double a ,double b){
        double c = a + b;
        return c;
    }

    // 计算3个整数的最小值
    public static int min1(int a , int b , int c ){
        int results = a < b ? a : b ;
        results = results < c ? results : c ;
        return results;
    }

}
