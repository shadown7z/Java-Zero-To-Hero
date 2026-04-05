package day10_ObejectHigh.test3;

public class Manager extends Coder {
    private int bonus;
    public void Manager(){
    }

    public Manager(String name, int age,int salary, int bonus) {
        super(name,age,salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("姓名为" + super.getName()
                + ",年龄为" + super.getAge()
                + ",工资为" + super.getSalary()
                + ",奖金为" + bonus + "的项目经理正在分配任务...");

    }
    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
