# This is a README.md

## Java笔记：
**2026年3月30日：**

**自动生成局部变量：**
`变量.var`+回车

**快速数组遍历：**
`数组名.fori`+回车

**Java数组元素反转---使用“双指针法”在原地（in-place）反转一个数组：**
```java
    public static void reverseArray(int[] arr){
        // 定义了start开始和end结束 | 定义了循环条件，无论数组长度是偶或奇，都会结束 | 每循环一次，start+1,end-1
        for(int start = 0 , end = arr.length -1 ;start < end; start++ , end--){
            //典型的交换数组元素
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
```

**Java水仙花数案例---练习For循环和If判断：**
```java
    public static int getCount(){
    // 主要是对每一个数进行取模，然后拿出来乘3次方之后相加
        int count = 0;
        for (int i = 100 ; i <= 999 ; i++){
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100;
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }
```
**2026年4月2日，因为昨天晚上没睡好，今天没有精神，特别瞌睡，给自己放假一天**

**2026年4月3日：**

**JavaBean：一套约定俗成的类写法。规范，1.公共无惨构造器，2.属性私有化,3.提供Getter/Setter**

**JavaBean的主要应用场景：通常用于数据的传输**

**Constructor构造方法（构造器），在创建对象时自动执行构造器，且允许重载**

**封装：内部私有，外部接口.保护数据，隐藏复杂性**
```java
public class Account {
    private double balance; // 私有属性，防止被外部直接修改

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount; // 封装了业务逻辑
        }
    }
}
```

**继承：孩子继承父亲的家产.实现代码复用，定义层级**
```java
// 1. 继承：建立父类
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    // 父类定义一个通用的方法
    public void makeSound() {
        System.out.println("动物在发出声音...");
    }
}

// 2. 继承：Dog 继承自 Animal
class Dog extends Animal {
    public Dog(String name) {
        super(name); // 调用父类的构造函数
    }

    // 重写 (Override)：这是实现多态的关键
    @Override
    public void makeSound() {
        System.out.println(name + " 说: 汪汪!");
    }
}

// 2. 继承：Cat 继承自 Animal
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " 说: 喵喵!");
    }
}

// 3. 多态的实际应用
public class Main {
    public static void main(String[] args) {
        // 多态的核心：父类引用指向子类对象
        // 虽然类型都是 Animal，但表现出的行为不同
        Animal myDog = new Dog("大黄");
        Animal myCat = new Cat("小花");

        // 调用相同的方法名，结果却不同
        performSound(myDog); // 输出: 大黄 说: 汪汪!
        performSound(myCat); // 输出: 小花 说: 喵喵!
    }

    // 这是一个多态方法：它只接受 Animal 类型
    // 这样无论以后增加什么动物，这个方法都不用改
    public static void performSound(Animal animal) {
        animal.makeSound();
    }
}
```

**多态：一份蓝图，多种实现.提高灵活性，支持模块化扩展**
```java
public interface Payment {
    void pay(double amount);
}

public class AliPay implements Payment {
    public void pay(double amount) { System.out.println("支付宝支付: " + amount); }
}

public class WeChatPay implements Payment {
    public void pay(double amount) { System.out.println("微信支付: " + amount); }
}

// 架构师视角：业务代码只依赖接口，不依赖具体实现
public class OrderService {
    public void process(Payment method, double total) {
        method.pay(total); // 运行时根据传入的实例决定调用哪个方法
    }
}
```

**过度封装会增加开发成本，过度继承会导致类爆炸，而没有多态则会让系统僵死。**

**2026年4月4日，今天需要把马原过一遍，因为离自考本还有一两周,所以今天休息一天**

**2026年4月5日：**

**`this`和`super`：**

**`this`：代表本类对象的引用。**
**`super`：代表父类存储空间的标识**

**`Object`类：**

**所有的类，都直接或间接继承了`Object`类（祖宗类）**

**而`Object`中的`toString`就是让你重写的，因为在你创建类的时候自动继承Object类：**

```java
    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
```

**`final`关键字：是最终的意思，可以修饰（方法，类，变量）**

                基本数据类型变量: 数据值不可改变
                引用数据类型变量: 地址值不可改变

                final修饰成员变量, 初始化时机
                        1. 在定义的时候完成赋值
                        2. 在构造方法结束之前完成赋值.
```java
class A {
    final int num;

    public A(int num) {
        this.num = num;
    }
}
```
**抽象类：是一种特殊的父类，内部可以编写抽象方法**
**抽象方法`abstract`：特点，强制要求子类重写**
```java
abstract class Animal {
    public abstract void eat();

    public void drink(){
        System.out.println("喝水");
    }
}
```
```java
/*
        抽象类的注意事项:
            1. 抽象类不能实例化
                    原因: 如果允许创建对象, 就可以调用抽象方法了, 这样做没意义
            2. 抽象类不能创建对象, 里面还是存在构造方法
                    原因: 构造方法是交给子类通过super()调用的.
            3. 抽象类中可以编写普通的方法
                    原因: 子类可以直接继承到这些方法使用.
            4. 抽象类的子类
                    A: 重写所有抽象方法
                    B: 将子类改造为抽象类
 */
```

**2026年4月6日，今天因为要推比赛进度，一直在弄香橙派和pegasus，所以今天休息一天**

**2026年4月7日，复习自考本和弄pegasus**

**2026年4月8日，复习自考本**

**2026年4月9日，复习自考本**

**2026年4月10日，复习自考本**

**2026年4月11日，自考本考试**

**2026年4月12日，自考本考试**

**2026年4月13日，做比赛项目，因为项目15号截止**

**2026年4月14日，做比赛项目**

**2026年4月15日：**

**设计模式: 一些优秀的程序员, 总结出来的经验**

**模板设计模式: 将抽象类整体看作为是一个模板, 模板中不能决定的内容, 定义为抽象方法 让使用模板的类, 补齐抽象方法的逻辑**

**`final`，可以限制子类不可重写**

**接口：体现的思想是对规则的声明，Java中的接口更多体现的是对行为的抽象**

**接口定义和使用：接口关键字`interface`来定义，接口和类之间是实现关系，通过`implements`关键字表示**

**2026年4月16日：**

**IDEA快捷键：Ctrl+R 一键替换**

**2026年4月19日:**

**栈：先进后出**

**队列：先进先出**

**数据结构：**

**数组：查询与更改快，增删慢**

**链表：查询与修改慢，增删相对于数组较快，首尾操作极快**

**泛型：1.统一数据类型。2.将运行期的错误提升到了编译期。（如果没有指定类型默认为Object）**

**泛型常见标识符：E:Element元素。T:Type类型。K:Key键。V:Value值**

**泛型非静态方法：泛型是根据类的泛型去匹配的**

**泛型静态方法：需要声明出自己独立的泛型**

**2026年4月20日：**

**TreeSet保留重复的方法：CompareTo比较过后，返回非0数字(1或-1最好)进行保留**

**TreeSet中比较器排序优先于自然排序（重写CompareTo方法的排序）**

**TreeSet比较器排序，参数1-参数2，正序。参数2-参数1倒序**

**HashSet集合保证元素唯一，需要同时重写hashCode和equals方法**

**HashSet底层结构（jdk8版本）：数组+链表+红黑树**

**HashSet底层原理：（jdk8以前头插法，jdk8以后尾插法）字符串比较时计算它的取模值（哈希值），例如数组长度15，取模值15。JDK8开始，当链表长度超过8，且数组长度>=64时，自动将链表转换为红黑树**

**HashSet当数组存满到16 * 0.75 = 12 时，就自动扩容，每次扩容为原先容量的两倍（0.75为加载因子）**

**LinkHashSet:有序，不重复**

**应用场景：想要集合中的元素可重复，就用ArrayList集合。相对集合中的元素去重，用HashSet,基于哈希表**

**相对集合中的元素去重，而且保证存取顺序，用LinkedHashSet集合，基于哈希表和双链表，效率低于HashSet**

**相对集合中的元素进行排序，用TreeSet集合，基于红黑树**

**Collections工具类：可变参数，可以在形参中接收多个数据，格式`数据类型...参数名称`**

**Map集合：一种双列集合，每个元素包含两个数据，元素格式`key = value`（键值对格式）**

**Map常用的API：`map.remove`删除(根据键名删除键值对),`map.put`添加或覆盖，如果键名相同，则覆盖前一个的value值，并返回**

**`map.containsKey`，按键查找。`map.containsValue`，按值查找**

**Map遍历的三种方式：**
1. 键找值（通过`KeySet`获取键，通过`get`获取值）
```java
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("张三", "北京");
        map.put("李四", "上海");
        map.put("王五", "成都");

        // 1. 获取Map集合中, 所有的键
        Set<String> keySet = map.keySet();
        // 2. 遍历set集合, 获取每一个键
        for (String key : keySet) {
            // 3. 通过map集合的get方法, 根据键查找对应的值
            String value = map.get(key);
            System.out.println(key + "---" + value);
        }
    }
```
2. 通过键值对对象获取键和值
```java
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("张三", "北京");
        map.put("李四", "北京");
        map.put("王五", "北京");

        // 1. 调用entrySet方法, 获取所有的键值对对象.
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        // 2. 遍历Set集合, 获取每一个键值对对象
        for (Map.Entry<String, String> entry : entrySet) {
            // 3. 通过键值对对象, 获取键和值
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "---" + value);
        }
    }
```
3. 通过foreach方法遍历
```java
    public static void main(String[] args) {
    Map<String, String> map = new TreeMap<>();
    map.put("张三", "北京");
    map.put("李四", "北京");
    map.put("王五", "北京");

    map.forEach((key, value) -> System.out.println(key + "---" + value));
    map.forEach((k, v) -> System.out.println(k + "---" + v));
}
```

**Map接口：**
- 双列集合的数据结构，都只针对于键有效，和值没有关系
- TreeMap : 键(红黑树)(键排序)
- HashMap : 键(哈希表)(键唯一)
- LinkedHashMap : 键(哈希表 + 双向链表)(键唯一，并保证顺序)

**Stream流：配合Lambda表达式，简化集合和数组操作**
> - Ctrl + Alt + M 代码段直接变成方法(选中代码段)
> - 流中的操作不会修改数据源,需要做Stream流的收集操作

**2026年4月22日：异常**

**Exception异常：**
- 运行时异常
- 编译时异常(如日期解析异常)

**解决方式：**
- 抛出异常(throws)
- 捕获异常(try...catch)
- Ctrl + T 快捷键选择常用的逻辑代码
- `e.printStackTrace`和`throw new xxx`

**运行异常代码部分：（运行异常继承RuntimeException）**
```java
package day15_Exception;

public class ExceptionDemo1 {
    // 主代码
    public static void main(String[] args) {
        int x = 101;
        System.out.println("开始了");
        try {
            save(x);
            System.out.println("执行成功了");
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常对象信息
            System.out.println("执行失败了");
        }
        System.out.println("结束了");
    }

    private static void save(int age) {

        if (age <= 0 || age > 100) {
            throw new ArithmeticException("/x is error");
        }
        System.out.println("年龄保存成功了，年龄是："+age);

    }

}
```

```java
package day15_Exception;

public class ARuntimeException extends RuntimeException  {
    //自定义的运行异常代码
    public ARuntimeException(String message) {
        super(message);
    }
}
```

**开发中对于异常的常见处理方式：**
- 捕获异常，记录异常并响应合适的信息给用户
- 捕获异常，尝试重新修复

**File类：**
- 绝对路径:`File f = new File("D:\\A.txt)` ,没有文件或文件夹返回false
- 相对路径:相对于项目
- `f.getAbsoluteFile()` 获取绝对路径
- `File f = new File("A.txt")`,`f.createNewFile()` 创建文件

**File类常见的API（判断相关）:**
- `f.isDirectory()`,判断此路径名表示的File是否为文件夹
- `f.isFile()`,判断此路径名表示的File是否为文件
- `f.exists()`,判断此路径名表示的File是否存在

**File类常见的API（获取相关）:**
- `f.length()`,返回文件的大小(字节数量)
- `f.getAbsolutePath()`,返回文件的绝对路径
- `f.getPath()`,返回定义文件时使用的路径
- `f.getName()`,返回文件的名称,带后缀
- `f.lastModified()`,返回文件的最后修改时间(时间毫秒值)

**File类常见的API（创建和删除相关）:**
- `f.createNewFile()`,创建一个新的空的文件
- `f.mkdir()`,只能创建一级文件夹
- `f.mkdirs()`,可以创建多级文件夹
- `f.delete()`,删除文件或文件夹(强制删除)

**File类常见的API（遍历相关）:**
- `File[] listFiles()`,获取当前目录下所有的"一级文件对象",返回File数组
```java
import java.io.File;

public class FileTest2 {
    /*
        需求：键盘录入一个文件夹路径，找出这个文件夹下所有的 .java 文件

        public File[] listFiles()  获取当前目录下所有的  “一级文件对象”  返回 File 数组
     */
    public static void main(String[] args) {

        File dir = FileTest1.getDir();

        printJavaFile(dir);
    }

    private static void printJavaFile(File dir) {
        // 1. 获取当前文件夹下所有的文件和文件夹对象
        File[] files = dir.listFiles();
        // 2. 遍历数组, 获取每一个文件和文件夹对象
        for (File file : files) {
            // 3. 判断当前对象是否是文件, 并且是java文件
            if(file.isFile() && file.getName().endsWith(".java")){
                // 4. 打印在控制台
                System.out.println(file);
            }
        }
    }
}
```
**递归:方法直接或间接调用本身**
> 递归如果没有控制好终止，会出现递归死循环，导致内存溢出现象
```java
public class RecursionDemo2 {
    /*
        需求: 使用递归求5的阶乘

        5的阶乘（5!）:  5 * 4 * 3 * 2 * 1

            5的阶乘（5!）:  5 * 4!
            4的阶乘（4!）:  4 * 3!
            3的阶乘（3!）:  3 * 2!
            2的阶乘（2!）:  2 * 1!
            1的阶乘（1!）:  1
     */
    public static void main(String[] args) {
        System.out.println(jc(5));
    }

    public static int jc(int num) {
        if (num == 1) {
            return 1;
        } else {
            // 思路: 需要调用一个方法, 获取4的阶乘
            // 5 * jc(4)
            // 4 * jc(3)
            // ...
            return num * jc(num - 1);
        }
    }
}
```

**递归练习——不死身兔（斐波那契数列）：**
```java
public class RecursionTest {
    /*
        有一对兔子，从出生后第3个月起每个月都生一对兔子
        小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问第二十个月的兔子对数为多少？

        规律: 从第三个月开始，兔子的对数是前两个月相加的和
     */
    public static void main(String[] args) {
        System.out.println(get(20));
    }

    public static int get(int month) {
        // 第一个, 第二个月兔子的对数为1
        if (month == 1 || month == 2) {
            return 1;
        } else {
            // 第三个月: 第一个月 + 第二个月  month 3
            // 第四个月: 第二个月 + 第三个月  month 4
            // ...
            return get(month - 2) + get(month - 1);
        }
    }
}
```

**递归练习——找出所有.java文件**
```java
public class FileTest3 {
    /*
        需求：键盘录入一个文件夹路径，找出这个文件夹下所有的 .java 文件 (考虑子文件夹)

     */
    public static void main(String[] args) {
        File dir = FileTest1.getDir();
        printJavaFile(dir);
    }

    private static void printJavaFile(File dir) {
        // 获取当前目录下, 所有文件和文件夹对象
        File[] files = dir.listFiles();
        // 遍历数组, 获取每一个文件和文件夹对象
        for (File file : files) {
            // 如果是文件, 并且是.java文件, 就打印在控制台
            if (file.isFile() && file.getName().endsWith(".java")) {
                System.out.println(file);
            } else if (file.isDirectory()) {
                // 说明是文件夹, 进入这个文件夹, 继续查找.java文件
                // 思路: 需要调用一个方法, 进入文件夹查找.java文件, 发现自己这个方法就是解决此问题, 递归调用.
                if (file.listFiles() != null) {
                    printJavaFile(file);
                }
            }
        }
    }
}
```

**递归练习——删除文件夹**
```java
public class FileTest4 {
    /*
        需求 : 设计一个方法, 删除文件夹
        注意 : delete() 只能删除空文件夹
     */
    public static void main(String[] args) {
        File dir = new File("E:\\test");
        deleteDir(dir);
    }

    private static void deleteDir(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            } else {
                if (file.listFiles() != null) {
                    deleteDir(file);
                }
            }
        }
        dir.delete();
    }
}
```
**递归练习——统计文件夹大小**
```java
public class FileTest5 {
    /*
        需求: 键盘录入一个文件夹路径，统计文件夹的大小
     */
    public static void main(String[] args) {
        File dir = FileTest1.getDir();

        long length = getDirLength(dir);

        System.out.println("字节数量为:" + length);
    }

    private static long getDirLength(File dir) {
        long result = 0;
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                result += file.length();
            } else {
                if (file.listFiles() != null) {
                    result += getDirLength(file);
                }
            }
        }
        return result;
    }
}
```
**2026年4月22日：常用API与多线程**

**Math类：**
```java
    /*
        Math类 : 包含执行基本数字运算的方法

        --------------------------------------------------------------------
        public static int abs (int a) : 获取参数绝对值
        public static double ceil (double a) : 向上取整
        public static double floor (double a) : 向下取整
        public static int round (float a) : 四舍五入
        public static int max (int a, int b) : 获取两个int值中的较大值
        public static double pow (double a,double b) : 返回a的b次幂的值
        public static double random () : 返回值为double的随机值，范围[0.0,1.0)
        --------------------------------------------------------------------
     */
```
**System类:**
```java
    /*
    System类常见方法 :

        1. public static void exit (int status) : 终止当前运行的 Java 虚拟机，非零表示异常终止
        2. public static long currentTimeMillis () : 返回当前系统的时间毫秒值形式
                                                            - 返回1970年1月1日 0时0分0秒, 到现在所经历过的毫秒值
                                                            - 返回1970年1月1日 8时0分0秒, 到现在所经历过的毫秒值

        3. public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) : 数组拷贝

                                                    1. 数据源数组
                                                    2. 起始索引
                                                    3. 目的地数组
                                                    4. 目的数组的起始索引
                                                    5. 拷贝的个数
          System.arraycopy([源数组],[起始索引],[目的数组],[目的数组起始索引],[拷贝的个数])
 */
```
**包装类：** 将基本数据类型，包装成类(变成引用数据类型)
> 除了`Integer(int)`,`Character(char)`两种其余都是首字母大写

**基本数据类型包装成类：**
```java
    /*
        将基本数据类型, 包装成类 (变成引用数据类型)

        byte            Byte
        short           Short
        int             Integer
        long            Long
        char            Character
        float           Float
        double          Double
        boolean         Boolean

        手动装箱: 手动调用 Integer.valueOf() 方法, 将基本数据类型, 手动包装为类
        手动拆箱: 手动调用 Integer中的 intValue() 方法, 将包装类对象, 转换为基本数据类型

        自动拆装箱: 基本数据类型和对应的包装类, 可以直接运算, 操作起来非常便捷
     */
```
**Integer类的常见方法:**
```java
    /*
        Integer类的常见方法:

            public static String toBinaryString(int i)      得到二进制
            public static String toOctalString(int i)       得到八进制
            public static String toHexString(int i)         得到十六进制
            public static int parseInt(String s)            将字符串类型的整数转成int类型的整数

     */
```
**练习：**
```java
    /*
        已知字符串
        String s = "10,50,30,20,40";

        请将该字符串转换为整数并存入数组
        随后求出最大值打印在控制台
     */
    public static void main(String[] args) {
        String content = "10,50,30,20,40";

        String[] arr = content.split(",");

        int[] nums = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        System.out.println("最大值为:" + max);
    }
```

**BigDecimal类:（解决小数运算精度损失问题）**
```java
    /*
        BigDecimal类 : 用于解决小数运算中, 出现的不精确问题

        BigDecimal创建对象 :

                public BigDecimal(double val) : 不推荐, 无法保证小数运算的精确
                ---------------------------------------------------------------
                public BigDecimal(String val)
                public static BigDecimal valueOf(double val)

        BigDecimal常用成员方法 :

                public BigDecimal add(BigDecimal b) : 加法
                public BigDecimal subtract(BigDecimal b) : 减法
                public BigDecimal multiply(BigDecimal b) : 乘法
                public BigDecimal divide(BigDecimal b) : 除法
                public BigDecimal divide (另一个BigDecimal对象，精确几位，舍入模式) : 除法

                                RoundingMode.HALF_UP : 四舍五入
                                RoundingMode.UP : 进一法
                                RoundingMode.DOWN : 去尾法

        注意: 如果使用BigDecimal运算, 出现了除不尽的情况, 就会出现异常
     */
```
**Arrays数组工具类:**
```java
        /*
            Arrays 数组操作工具类, 专门用于操作数组元素
    
            public static String toString(类型[] a)                将数组元素拼接为带有格式的字符串
            public static boolean equals(类型[] a, 类型[] b)        比较两个数组内容是否相同 (元素, 个数, 顺序)
            public static int binarySearch(int[] a, int key)       查找元素在数组中的索引 (二分查找法)
                                                                            - 注意: 操作的数组, 必须是排好顺序.
            public static void sort(类型[] a)                       对数组进行默认升序排序
         */
```
**Data类:**
```java
    /*
         Date类 : 表示时间的类

            1. 构造方法 :

                public Date() : 将当前时间, 封装为Date日期对象
                public Date(long time) : 把时间毫秒值转换成Date日期对象

            2. 常见方法 :

                public long getTime() : 返回从1970年1月1日 00:00:00走到此刻的总的毫秒数
                public void setTime(long time) : 设置日期对象的时间为当前时间毫秒值对应的时间

     */
```
**SimpleDateFormat类:(时间格式化)**
```java
    /*
    SimpleDateFormat类 : 用于日期格式化

    1. 构造方法 :

            public SimpleDateFormat() : 创建一个日期格式化对象, 使用 [默认模式]
            public SimpleDateFormat(String pattern) : 创建一个日期格式化对象, [手动指定模式]

    2. 常用方法 :

            public final String format(Date date) : 将日期对象, 转换为字符串
            public final Date parse(String source) : 将日期字符串, 解析为日期对象

 */
```
**LocalDateTime类：**
```java
    /*
       ------------------------------------------
       LocalDate、LocalTime、LocalDateTime

       对象的创建方式:

       1. now() : 当前时间

       2. of(...) : 设置时间

       ------------------------------------------
       LocalDateTime 转换LocalDate, LocalTime

       1. toLocalDate()
       2. toLocalTime()
    */
```
**修改时间:**
```java
    public static void main(String[] args) {
        LocalDateTime nowTime = LocalDateTime.now();

        // 当前时间
        System.out.println(nowTime);
        // minus : 减去
        // minusYears(年), minusMonths(月), minusDays(日), minusWeeks(周), minusHours(时), minusMinutes(分), minusSeconds(秒), minusNanos(纳秒)
        System.out.println("减一小时:" + nowTime.minusHours(1));
        System.out.println("减一分钟:" +nowTime.minusMinutes(1));
        System.out.println("减一秒钟:" +nowTime.minusSeconds(1));
        System.out.println("减一纳秒:" +nowTime.minusNanos(1));

        System.out.println("对比时间, 确定方法返回的都是新的实例 >>>>>> " + nowTime);

        System.out.println("----------------");

        // plus : 加
        // plusYears(年), plusMonths(月), plusDays(日), plusWeeks(周), plusHours(时), plusMinutes(分), plusSeconds(秒), plusNanos(纳秒)
        System.out.println("加一小时:" + nowTime.plusHours(1));
        System.out.println("加一分钟:" + nowTime.plusMinutes(1));
        System.out.println("加一秒钟:" + nowTime.plusSeconds(1));
        System.out.println("加一纳秒:" + nowTime.plusNanos(1));

        System.out.println("---------------");

        // with : 这里体现出的是,设置效果
        System.out.println("修改的效果:");
        //withYear(年), withMonth(月), withDayOfMonth(日), withHour(时), withMinute(分), withSecond(秒), withNano(纳秒)
        System.out.println(nowTime.withYear(2008));
        System.out.println(nowTime.withMonth(8));
        System.out.println(nowTime.withDayOfMonth(8));
        System.out.println(nowTime.withHour(8));
        System.out.println(nowTime.withMinute(8));
        System.out.println(nowTime.withSecond(8));
        System.out.println(nowTime.withNano(8));
        System.out.println("---------------");

        LocalDate myDate = LocalDate.of(2008, 8, 8);
        LocalDate nowDate = LocalDate.now();

        //2008-08-08是否在nowDate之前?
        System.out.println(myDate + "是否在" + nowDate + "之前? " + myDate.isBefore(nowDate));

        //2008-08-08是否在nowDate之后?
        System.out.println(myDate + "是否在" + nowDate + "之后? " + myDate.isAfter(nowDate));
        System.out.println("---------------------------");

        // 判断两个时间是否相同
        System.out.println(myDate.equals(nowDate));
    }
```
**DateTimeFormatter类:(格式化时间):**
```java
    /*
        用于时间的格式化和解析:

        1. 对象的获取 :

                static DateTimeFormatter ofPattern(格式) : 获取格式对象

        2. 格式化 :

                String format(时间对象) : 按照指定方式格式化

        3. 解析 :

                LocalDateTime.parse("解析字符串", 格式化对象);
                LocalDate.parse("解析字符串", 格式化对象);
                LocalTime.parse("解析字符串", 格式化对象);

     */
```
**ChronoUnitDemo:**
```java
/**
 * ChronoUnit可用于在单个时间单位内测量一段时间，这个工具类是最全的了，可以用于比较所有的时间单位
 */
```

**IO流体系结构：字节流(万能流)和字符流(纯文本文件)**
> 字节流操作中文可能有乱码,这个时候就可以用字符流来代替

**字节流:**
**FileOutputStream(字节输出流):**
```java
    /*
      字节流写出数据

          构造方法:
                  1. public FileOutputStream(String name) : 输出流关联文件, 文件路径以字符串形式给出
                     public FileOutputStream(String name, boolean append) : 参数2为追加写入的开关

                  2. public FileOutputStream(File file) : 输出流关联文件, 文件路径以File对象形式给出
                     public FileOutputStream(File file, boolean append) : 参数2为追加写入的开关

          成员方法:
                  public void write(int i) : 写出一个字节
                  public void write(byte[] b) : 写出一个字节数组
                  public void write(byte[] b, int off, int len) : 写出字节数组的一部分

          细节:
                  输出流关联文件, 文件如果不存在: 会自动创建出来
                                  如果文件存在: 会清空现有的内容, 然后再进行写入操作
   */
```
> 记得`.close()`关闭流,不然资源无法释放

**FileOutputStream异常代码处理:**
```java
    /*
        IO流的异常处理方式: jdk7版本开始

        try
            (需要调用close方法的流对象)
            {
                IO流逻辑代码
            }
        catch (异常类名 对象名) {
            异常处理方案
        }

        ()中的流对象, 会自动调用close方法, 就算有异常, 也会调用close.
     */
```
**FileInputStream(输入流):**
```java
    /*
        FileInputStream 字节输入流读取数据

        1. 构造方法:

            FileInputStream(String name)    输入流关联文件, 文件路径以字符串形式给出
            FileInputStream(File file)      输入流关联文件, 文件路径以File对象形式给出

        2. 成员方法:

            public int read()               读取单个字节
            public int read(byte[] bys)     读取一个字节数组
                                                - 将读取到的字节, 存入数组容器, 返回读取到的有效字节个数

     */
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\A.txt");

        byte[] bys = new byte[2];

        // 将读取到的字节, 存入数组容器, 返回读取到的有效字节个数
        int len;
        while( (len = fis.read(bys)) != -1) {
            String s = new String(bys, 0, len);
            System.out.print(s);
        }

        fis.close();

    }

    private static void method1() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\A.txt");

        int i;
        while( (i = fis.read()) != -1 ){
            System.out.print((char)i);
        }

        fis.close();
    }
```
> 如果读取不到(也就是读完了)会返回 -1

**字符流:**
**FileReader(字符流读取):**
```java
    /*
    FileReader: 用于读取纯文本文件，解决中文乱码问题

        构造方法:
                1. public FileReader(String fileName) 字符输入流关联文件，路径以字符串形式给出
                2. public FileReader(File file) 字符输入流关联文件，路径以File对象形式给出

        成员方法:
                public int read() : 读取单个字符
                public int read(char[] cbuf) : 读取一个字符数组, 返回读取到的有效字符个数
 */
```
**FileWriter(字符流输出):**
```java
    /*
        FileWriter字符输出流写出数据 :

        构造方法:
                FileWriter(String fileName):                         字符输出流关联文件，路径以字符串形式给出
                FileWriter(String fileName, boolean append):         参数2: 追加写入的开关
                FileWriter(File file):                               字符输出流关联文件，路径以File对象形式给出
                FileWriter(File file, boolean append):               参数2: 追加写入的开关

        成员方法:
                public void write(int c)                             写出单个字符
                public void write(char[] cbuf)                       写出一个字符数组
                public void write(char[] cbuf, int off, int len)     写出字符数组的一部分
                public void write(String str)                        写出字符串
                public void write(String str, int off, int len)      写出字符串的一部分
     */
```
**FileWriter需要刷出数据(类似于一个缓冲区，需要刷一下):**
```java
    /*
        注意事项: 字符输出流写出数据, 需要调用flush或close方法, 数据才会写出

            flush() : 刷出数据, 刷出后可以继续写出
            close() : 关闭流释放资源, 顺便刷出数据, 关闭后不可以继续写出
     */
```
> **字节流使用场景:不是纯文本文件都用字节流**
> 
> **字符流使用场景:读写纯文本文件**

**Properties集合和方法:**
**集合:**
```java
    /*
        Properties作为集合的使用

            Object setProperty (String key, String value) : 类似Map集合的put方法
            String getProperty (String key) : 类似Map集合的get方法
            Set<String> stringPropertyNames() : 类似Map是集合的keySet方法
     */
```
**方法（类）:**
```java
    /*
        Properties 和 IO 有关的方法

            void load(InputStream inStream)     从输入字节流读取属性列表（键和元素对）
            void load(Reader reader)            从输入字符流读取属性列表（键和元素对）
            void store(OutputStream out, String comments)   将集合的键值对写出到文件(字节流)
            void store(Writer writer, String comments)      将集合的键值对写出到文件(字符流)
     */
```
> `Properties`最常见用途就是:存配置
> 
> 比如:数据库连接信息、项目环境配置、系统参数
```Properties
username=root
password=123456
url=jdbc://mysql://localhost:3306/test
```
**Hutool工具(提升开发效率):**
> 帮你把Java开发中常见的"重复、繁琐操作"封装好，让你少写很多代码
> 
> `.jar`文件就是一个压缩包,里面压缩的字节码文件,也就是`.class`文件
```java
    /*
        IOUtil常用方法
            copy(InputStream in, OutputStream out, int bufferSize)      字节流拷贝
            copy(Reader reader, Writer writer)                          字符流拷贝
            readLines(Reader reader, Collection<String> collection)     按行读取内容到集合
            close(Closeable closeables)                                 安全关闭流

        FileUtil常用方法
            touch(filePath)                                             创建文件（自动创建父目录）
            mkdir(dirPath)                                              创建目录（支持多级目录）
            copy(srcPath, destPath, isOverride)                         复制文件或目录（可选覆盖）
            move(srcFile, destDir, isOverride)                          移动文件或目录
     */
```
**进程:(正在运行的程序)**
> 程序：一份静态的代码（比如一个软件安装包） 
> 
>进程：这段代码被运行起来之后的“活动状态
> 
> **进程 = 程序 + 运行环境 + 当前状态**

**进程的特性:**
> **动态性：** 进程是“正在运行”的
> 
> **独立性：** 每个进程有自己的内存空间
> 
> **并发性：** 多个进程可以同时运行（看起来同时）
> 
> **生命周期：** 创建 → 运行 → 结束
> 
> **进程和线程的对比:** 进程 = 一家公司,线程 = 公司里的员工
> 
> **进程里面可以同时执行多个任务,每个任务就是线程**

**并行与并发的比较:**
> **并发**:单核运行，看起来"同时在做",但可能是**交替执行**.并发不一定同时，不需要多核
>
> **并行**:多核运行,真正"同时在做",是**物理上的同时执行**.并行需要同时，需要多核

**Java开启线程的方式:**
- 继承Thread类(不推荐),扩展性不好，不能多继承
- 实现Runnable接口(推荐),扩展性好，它可以多继承，因为它是一个接口
- 实现Callable接口,如果线程任务需要有返回值，可以用Callable接口

**线程相关方法:**
```java
    /*
        线程设置名字和获取名字

        Thread类的方法:

            public String getName() : 获取线程名字
            public void setName() : 设置线程名字
            public static Thread currentThread() : 获取当前线程的对象

     */
```
```java
    /*
        休眠线程的方法

        public static void sleep(long time) : 让线程休眠指定的时间，单位为毫秒
     */
```
```java
    /*
        线程优先级的方法:

            public setPriority(int newPriority) : 设置线程优先级
            public final int getPriority() : 获取线程优先级
     */
```
```java
    /*
        public final void setDaemon(boolean on) : 设置为守护线程
     */
```
**同步代码块`synchronized`:**
- 锁对象可以是任意对象,但是需要保证多条线程的锁对象,是同一把锁
- 同步可以解决多线程的数据安全问题,但是也会降低程序的运行效率

**同步方法:**
- 在方法的返回值类型前面加入`synchronized`关键字
- 方法分为静态和非静态
- 静态方法的锁对象是字节码对象,非静态方法的锁对象是this

**lock锁:**
```java
Lock lock = new ReentrantLock();

lock.lock();   // 加锁
try {
    // 业务代码（临界区）
} finally {
    lock.unlock(); // 解锁（一定要写）
}
```
**线程池:**

**作用:**

1. **线程复用**

不用每次都 new Thread

2. **控制线程数量**

避免系统崩溃（比如最多 10 个线程）

3. **任务排队**

线程忙不过来时，任务先排队
```java
import java.util.concurrent.*;

public class TestPool {

    public static void main(String[] args) {

        ExecutorService pool = new ThreadPoolExecutor(
                2,                      // 核心线程数
                4,                      // 最大线程数
                60, TimeUnit.SECONDS,   // 空闲存活时间
                new LinkedBlockingQueue<>(10) // 任务队列
        );

        pool.execute(() -> {
            System.out.println("任务1：" + Thread.currentThread().getName());
        });

        pool.shutdown();
    }
}
```

**线程池的工作原理:**
- 线程数 < corePoolSize → 直接创建线程
- 线程满了 → 放入队列
- 队列满了 → 创建新线程（最多到 maxPoolSize）
- 再满 → 执行拒绝策略

**自定义线程池:**
```java
import java.util.concurrent.*;

public class CustomThreadPool {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2, // 核心线程数
                4, // 最大线程数
                60, // 空闲线程存活时间
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), // 有界队列（重点）
                Executors.defaultThreadFactory(), // 线程工厂
                new ThreadPoolExecutor.AbortPolicy() // 拒绝策略
        );

        for (int i = 0; i < 5; i++) {
            int task = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName()
                        + " 执行任务：" + task);
            });
        }

        pool.shutdown();
    }
}
```
**七大参数:**
```java
import java.util.concurrent.*;

/**
 * 自定义线程池示例
 */
public class CustomThreadPoolDemo {

    public static void main(String[] args) {

        /**
         * ThreadPoolExecutor 七大参数详解：
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(

                /**
                 * 1. corePoolSize（核心线程数）
                 * -------------------------------------------------
                 * 👉 线程池中“长期存活”的线程数量
                 * 👉 即使空闲也不会被销毁（默认情况）
                 * 👉 这些线程优先处理任务
                 *
                 * 类比：公司正式员工数量
                 */
                2,

                /**
                 * 2. maximumPoolSize（最大线程数）
                 * -------------------------------------------------
                 * 👉 线程池允许创建的最大线程数量
                 * 👉 当核心线程 + 队列都满了，才会扩展线程
                 *
                 * 类比：正式员工 + 临时工总人数上限
                 */
                4,

                /**
                 * 3. keepAliveTime（空闲存活时间）
                 * -------------------------------------------------
                 * 👉 非核心线程空闲多久会被回收
                 * 👉 超过这个时间没有任务就销毁线程
                 *
                 * 类比：临时工多久没活就解雇
                 */
                60,

                /**
                 * 4. unit（时间单位）
                 * -------------------------------------------------
                 * 👉 keepAliveTime 的时间单位
                 */
                TimeUnit.SECONDS,

                /**
                 * 5. workQueue（任务队列）⭐重点
                 * -------------------------------------------------
                 * 👉 存放等待执行任务的队列
                 * 👉 当核心线程满了，任务先进入这里排队
                 *
                 * ⚠ 推荐使用“有界队列”，防止内存爆炸
                 *
                 * 类比：任务排队大厅
                 */
                new ArrayBlockingQueue<>(3),

                /**
                 * 6. threadFactory（线程工厂）
                 * -------------------------------------------------
                 * 👉 用来创建线程（可以自定义线程名）
                 * 👉 方便排查日志和问题
                 *
                 * 类比：给员工起名字的HR
                 */
                new ThreadFactory() {
                    private int count = 1;

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "my-thread-" + count++);
                    }
                },

                /**
                 * 7. handler（拒绝策略）⭐重点
                 * -------------------------------------------------
                 * 👉 当线程池和队列都满了之后如何处理新任务
                 *
                 * 常见策略：
                 * - AbortPolicy：直接抛异常（默认）
                 * - CallerRunsPolicy：让提交任务的线程自己执行
                 * - DiscardPolicy：直接丢弃任务
                 * - DiscardOldestPolicy：丢弃最早任务
                 */
                new ThreadPoolExecutor.AbortPolicy()
        );

        /**
         * 提交任务测试
         */
        for (int i = 1; i <= 10; i++) {
            int taskId = i;

            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName()
                        + " 执行任务：" + taskId);

                try {
                    Thread.sleep(1000); // 模拟任务执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        /**
         * 关闭线程池（不是立刻停止，会等任务执行完）
         */
        executor.shutdown();
    }
}
```
**2026年4月23日:**

**UDP:无连接协议**
> 不管连没连接成功，常用于在线视频，传输快，但是数据不安全易丢失，1次64kb

**TCP:连接协议**
> 需要确保连接成功，例如:下载软件,传输慢，但是数据安全
>
> 三次握手,四次挥手

**三次握手:"1.在吗？ 2.在的。 3.OK。"**
> 1和3为客户端,2为服务端

**四次挥手:"1.在吗？ 2.在的。 3.断了。 4.OK。"**
> 1和3为客户端,2和4为服务端

**TCP代码演示:**

**服务端:**
```java
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务端示例
 */
public class TCPServer {

    public static void main(String[] args) throws Exception {

        /**
         * 1. 创建 ServerSocket
         * --------------------------------------------------
         * 👉 作用：监听客户端连接
         * 👉 参数：端口号（必须和客户端一致）
         *
         * 类比：开一个“服务窗口”等待客户来连接
         */
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("服务端启动，等待连接...");

        /**
         * 2. accept() 阻塞等待客户端连接
         * --------------------------------------------------
         * 👉 没有客户端连接时会一直阻塞
         * 👉 一旦有客户端连接，就返回一个 Socket 对象
         *
         * 类比：有人打电话进来了
         */
        Socket socket = serverSocket.accept();

        System.out.println("客户端已连接");

        /**
         * 3. 获取输入流（读取客户端发来的数据）
         * --------------------------------------------------
         * 👉 TCP 是基于流的通信
         */
        InputStream is = socket.getInputStream();

        byte[] buffer = new byte[1024];
        int len = is.read(buffer);

        System.out.println("收到消息：" + new String(buffer, 0, len));

        /**
         * 4. 关闭资源
         */
        socket.close();
        serverSocket.close();
    }
}
```
**客户端:**
```java
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP客户端示例
 */
public class TCPClient {

    public static void main(String[] args) throws Exception {

        /**
         * 1. 创建 Socket
         * --------------------------------------------------
         * 👉 需要指定服务器IP + 端口
         *
         * 类比：拨打电话
         */
        Socket socket = new Socket("127.0.0.1", 8888);

        /**
         * 2. 获取输出流（向服务端发送数据）
         */
        OutputStream os = socket.getOutputStream();

        os.write("你好，我是客户端".getBytes());

        /**
         * 3. 关闭资源
         */
        socket.close();
    }
}
```

**UDP的代码演示:**

**接收端:**
```java
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP接收端
 */
public class UDPReceiver {

    public static void main(String[] args) throws Exception {

        /**
         * 1. 创建 DatagramSocket
         * --------------------------------------------------
         * 👉 绑定端口，监听数据
         *
         * 类比：开一个“收件箱”
         */
        DatagramSocket socket = new DatagramSocket(9999);

        /**
         * 2. 创建数据包用于接收数据
         */
        byte[] buffer = new byte[1024];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        System.out.println("等待接收数据...");

        /**
         * 3. 接收数据（阻塞）
         */
        socket.receive(packet);

        /**
         * 4. 解析数据
         */
        String msg = new String(packet.getData(), 0, packet.getLength());

        System.out.println("收到消息：" + msg);

        socket.close();
    }
}
```
**发送端:**
```java
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP发送端
 */
public class UDPSender {

    public static void main(String[] args) throws Exception {

        /**
         * 1. 创建 DatagramSocket
         * --------------------------------------------------
         * 👉 不需要指定端口（系统随机分配）
         *
         * 类比：准备寄信
         */
        DatagramSocket socket = new DatagramSocket();

        /**
         * 2. 准备数据
         */
        byte[] data = "你好，我是UDP发送端".getBytes();

        /**
         * 3. 创建数据包
         * --------------------------------------------------
         * 👉 需要指定：
         * - 数据
         * - 接收方IP
         * - 接收方端口
         */
        DatagramPacket packet = new DatagramPacket(
                data,
                data.length,
                InetAddress.getByName("127.0.0.1"),
                9999
        );

        /**
         * 4. 发送数据
         */
        socket.send(packet);

        socket.close();
    }
}
```

**枚举:一组固定、有限、不会改变的常量集合**
- 一周只有：周一 ~ 周日
- 状态只有：成功 / 失败 / 处理中
- 性别只有：男 / 女

**枚举基本定义:**
```java
enum Status {
    SUCCESS,
    FAIL,
    PROCESSING
}
```

**枚举的使用方式:**
```java
public class TestEnum {
    public static void main(String[] args) {

        Status status = Status.SUCCESS;

        System.out.println(status); // 输出：SUCCESS
    }
}
```
**带属性的枚举:**
```java
enum Status {

    SUCCESS(200, "成功"),
    FAIL(500, "失败");

    private int code;
    private String msg;

    // 构造器（默认 private）
    Status(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
```
**使用:**
```java
System.out.println(Status.SUCCESS.getCode()); // 200
```
**常用方法:**
```java
Status.SUCCESS.name();    // "SUCCESS"
Status.SUCCESS.ordinal(); // 下标（从0开始）
Status.valueOf("SUCCESS"); // 转换
```

**反射:就是加载器，在程序运行时，动态获取类的信息，并操作这个类**
```java
import java.lang.reflect.*;

class User {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "User{name='" + name + "'}";
    }
}

public class TestReflection {
    public static void main(String[] args) throws Exception {

        // 1. 获取 Class 对象
        Class<?> clazz = Class.forName("User");

        // 2. 创建对象
        Object obj = clazz.getDeclaredConstructor().newInstance();

        // 3. 获取方法
        Method method = clazz.getDeclaredMethod("setName", String.class);

        // 4. 调用方法
        method.invoke(obj, "张三");

        // 5. 输出
        System.out.println(obj);
    }
}
```

**注解:给代码加标签，让程序在运行或编译时做特殊处理**
> 本质是接口.
```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 运行时可用
@Target(ElementType.METHOD)         // 作用在方法上
public @interface MyAnnotation {
    String value();
}
```
**使用注解:**
```java
public class Test {

    @MyAnnotation("测试方法")
    public void testMethod() {
        System.out.println("执行方法");
    }
}
```
**用反射读取注解:**
```java
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {

        Class<?> clazz = Test.class;

        Method method = clazz.getMethod("testMethod");

        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation ann = method.getAnnotation(MyAnnotation.class);
            System.out.println(ann.value());
        }
    }
}
```
**元注解:用来“修饰注解的注解”**
> 给注解加注解
```java
import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME) // 运行时有效（可以反射读取）
@Target(ElementType.METHOD)         // 只能用在方法上
public @interface MyAnnotation {
    String value();
}
```

