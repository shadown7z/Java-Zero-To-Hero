package day06_PrecessControl;

import java.util.Random;
import java.util.Scanner;

public class LittleGame {
    public static void main(String[] args) {
        // 1. 初始化游戏数据
        int[] secretCode = generateSecretCode(); // 生成4个不重复的随机数
        int maxAttempts = 10;                    // 最大机会10次
        Scanner sc = new Scanner(System.in);

        System.out.println("--- 欢迎来到猜数字游戏 (XAXB) ---");
        System.out.println("系统已生成4个不重复的数字，你有 " + maxAttempts + " 次机会。");

        // 2. 开始游戏循环
        gameLoop: // 这里用到了你刚才问的标签 (Label)
        for (int i = 1; i <= maxAttempts; i++) {
            System.out.print("\n第 " + i + " 次尝试，请输入4个数字 (如 1234): ");
            String input = sc.next();

            // 检查输入长度
            if (input.length() != 4) {
                System.out.println("错误：请输入正好4位数字！");
                i--; // 不计入次数
                continue;
            }

            // 将字符串转为数组
            int[] guess = new int[4];
            for (int k = 0; k < 4; k++) {
                guess[k] = input.charAt(k) - '0';
            }

            // 3. 计算 A 和 B 的数量
            int countA = 0;
            int countB = 0;

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (guess[j] == secretCode[k]) {
                        if (j == k) {
                            countA++; // 数字对，位置也对
                        } else {
                            countB++; // 数字对，位置不对
                        }
                    }
                }
            }

            // 4. 反馈结果
            System.out.println("结果：" + countA + "A" + countB + "B");

            if (countA == 4) {
                System.out.println("恭喜你！猜对了！答案就是 " + input);
                break gameLoop; // 跳出整个游戏循环
            }

            if (i == maxAttempts) {
                System.out.print("机会用完啦！正确答案是: ");
                for (int n : secretCode) System.out.print(n);
                System.out.println();
            }
        }
        sc.close();
    }

    // 生成4个不重复随机数的方法
    public static int[] generateSecretCode() {
        int[] code = new int[4];
        Random r = new Random();
        boolean[] used = new boolean[10]; // 记录0-9哪些被用了

        for (int i = 0; i < 4; i++) {
            int num;
            do {
                num = r.nextInt(10);
            } while (used[num]); // 如果数字重复，重新生成
            code[i] = num;
            used[num] = true;
        }
        return code;
    }
}