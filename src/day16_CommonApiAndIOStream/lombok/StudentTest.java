package day16_CommonApiAndIOStream.lombok;

import day16_CommonApiAndIOStream.pojo.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(18);
        System.out.println(stu1.getName() + "---" + stu1.getAge());

        Student stu2 = new Student("李四", 24);
        System.out.println(stu2);
    }
}