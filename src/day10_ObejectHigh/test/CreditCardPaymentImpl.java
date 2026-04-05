package day10_ObejectHigh.test;

public class CreditCardPaymentImpl implements Payment {

    @Override
    public void pay(double money) {
        System.out.println("通过信用卡支付了" + money + "元!");
    }
}
