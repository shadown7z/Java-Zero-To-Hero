package day13_ATMSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {

    // 1.定义一个集合容器存储全部的集合
    private ArrayList<Account> allAccounts = new ArrayList<>();
    // 2.准备一个扫描器，后面都要用
    private Scanner sc = new Scanner(System.in);

    // 3.展示一个欢迎界面。
    public void start() {
        while (true) {
            System.out.println("=============欢迎进入东方银行ATM系统=================");
            System.out.println("1.用户登录");
            System.out.println("2.用户开户");
            System.out.println("请您输入操作命令：");
            String command = sc.next();
            switch (command) {
                case "1":
                    // 登录
                    login();
                    break;
                case "2":
                    // 开户
                    registerAccount();
                    break;
                default:
                    System.out.println("您输入的命令有误，请重新输入!");
            }
        }
    }

    /**
     *  用户登录
     */
    private void login() {
        System.out.println("=============用户登录===============");
        if (allAccounts.size() == 0) {
            System.out.println("一个账户也没有，不能登录，请先开户！");
            return;
        }
        while (true) {
            System.out.println("请输入您的卡号：");
            String cardId  = sc.next();

            // 1.根据卡号查询账户对象，查询道路说明卡号对了
            Account loginAccount = getAccountByCardId(cardId);
            if (loginAccount == null) {
                System.out.println("卡号不存在，请重新输入");
                continue;
            }

            // 2.卡号对了，开始认证密码
            System.out.println("请您输入您的密码：");
            String passWord = sc.next();
            if(!loginAccount.getPassword().equals(passWord)){
                // 密码错误了
                System.out.println("您输入的密码有毛病！请重新确认账户!");
                continue;
            }

            // 3. 登录成功了
            System.out.println("恭喜您，"+loginAccount.getUserInfo()+"登录成功，您的卡号："+loginAccount.getCardId());
            // 展示登录后的操作界面
            showUserCommand();

        }
    }

    /**
     *  展示用户登录后的界面
     */
    private void showUserCommand() {
    }

    /**
     *  用户开户
     */
    private void registerAccount() {
        System.out.println("=============用户开户===============");
        // 1.创建一个开户对象
        Account acc = new Account();

        // 2.输入数据注入给账户对象封装
        System.out.println("请输入账户名称：");
        String UserName = sc.next();
        acc.setUserName(UserName);

        while (true) {
            System.out.println("请输入您的性别：");
            String sex  = sc.next();
            if ("男".equals(sex) || "女".equals(sex)){
                acc.setSex(sex.charAt(0));
                break;
            }else  {
                System.out.println("性别必须是男或者女!请重新输入！");
            }
        }

        while (true) {
            System.out.println("请输入账户密码：");
            String passWord = sc.next();
            System.out.println("请再次输入确认密码：");
            String okpassWord = sc.next();
            if (passWord.equals(okpassWord)) {
                acc.setPassword(passWord);
                break;
            }else{
                System.out.println("您两次输入的密码不一致，请重新输入!");
            }
        }

        // 每次限额
        while (true) {
            System.out.println("请您输入每次取现额度");
            double limitMoney = sc.nextDouble();
            if (limitMoney >= 1000){
                acc.setLimit(limitMoney);
                break;
            } else {
                System.out.println("每次取现额度必须大于等于1000元!");
            }
        }

        // 为账户生产一个8位的数字卡号，且要求与其他账户的卡号不重复(独立)
        while (true) {
            String cardId = "";
            Random r = new Random();
            for (int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }
            // 判断这个卡号是否已经存在，存在就不能作为新卡号，不存在才能作为新卡号
            Account otherAcc = getAccountByCardId(cardId);
            if(otherAcc == null){
                // 这个卡号不存在，可以作为新卡号
                acc.setCardId(cardId);
                break;
            }else {
            }
        }

        // 3.把账户对象加入到集合容器中去
        allAccounts.add(acc);
        System.out.println("恭喜您，开户成功！您的卡号是："+acc.getCardId()+"，请妥善保管!");
    }

    /**
     * 根据卡号查询账户对象返回
     * @param cardId
     * @return
     */
    public Account getAccountByCardId(String cardId) {
        for (int i = 0; i < allAccounts.size(); i++) {
            Account acc = allAccounts.get(i);
            if(acc.getCardId().equals(cardId)){
                // 找到相同的卡号就终止循环，返回acc
                return acc;
            }
        }
        // 如果没找到相同的卡号，说明这个卡号是空的可以使用直接返回Null
        return null;
    }
}
