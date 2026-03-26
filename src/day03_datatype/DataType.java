package day03_datatype;

public class DataType {
    public static void main(String[] args) {
        //2026年3月26日，今天学习数据类型和二进制的转换
        // 1、 byte 字节整型，1字节，范围：-128~127
        byte age = 12;

        // 2、short 短整型，2字节，范围：-32768~32767
        short number = 32432;

        // 3、int 整型（默认），4字节，范围：-2147483648~2147483647(10位数，大概21亿多)
        int number2 = 424244242;

        // 4、long长整型，8字节，-9223372036854775808 ~ 9223372036854775807 (19位数)、
        long lg = 324324324;

        // 5、float 单精度浮点型，4字节，范围：1.401298 E -45 到 3.4028235 E +38
        // 注意：随便写小数默认是double，如果希望小数是float加上F/f
        float ft = 3.14f;

        // 6、double（默认）双精度，8字节，范围：4.9000000E-324到1.797693E+308
        double ft2 = 3.15;

        // 7、char 单字符，2字节，0-66535
        char c = 'a';
        char c2 = '中';

        // 8、boolean 布尔值，1字节，true，false
        boolean flag = false;
        boolean flag2 = false;

        // String  字符串类型（引用数据类型）
        // String的变量可以用于记住字符串数据
        String name = "Shadown7z";
        System.out.println(name);
    }
}
