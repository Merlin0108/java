package lab1;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count50 = 5;
        int count100 = 5;
        int count1000 = 5;

        int sum = -1;

        while (sum <= 0) {
            System.out.print("Введите сумму для снятия (положительное число): ");
            if (scanner.hasNextInt()) {
                sum = scanner.nextInt();
                if (sum <= 0) {
                    System.out.println("Ошибка: сумма должна быть положительной.");
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }
        scanner.close();

        int originalAmount = sum;

        int notes1000 = 0;
        int notes100 = 0;
        int notes50 = 0;

        if (sum >= 1000 && count1000 > 0) {
            notes1000 = Math.min(sum / 1000, count1000);
            sum -= notes1000 * 1000;
        }

        if (sum >= 100 && count100 > 0) {
            notes100 = Math.min(sum / 100, count100);
            sum -= notes100 * 100;
        }

        if (sum >= 50 && count50 > 0) {
            notes50 = Math.min(sum / 50, count50);
            sum -= notes50 * 50;
        }

        if (sum > 0) {
            System.out.println("Не удалось выдать сумму " + originalAmount + " рублей.");
        } else {
            System.out.println("Выдано: ");
            if (notes1000 > 0) {
                System.out.println(notes1000 + " купюра(ы) по 1000 рублей");
            }
            if (notes100 > 0) {
                System.out.println(notes100 + " купюра(ы) по 100 рублей");
            }
            if (notes50 > 0) {
                System.out.println(notes50 + " купюра(ы) по 50 рублей");
            }
        }
    }
}