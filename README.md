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


**2026年4月6日，今天因为要推比赛进度，一直在弄香橙派和pegasus，所以今天休息一天**

**2026年4月7日，复习自考本和弄pegasus**

**2026年4月8日，复习自考本**

**2026年4月9日，复习自考本**

**2026年4月10日，复习自考本**
