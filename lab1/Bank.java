package lab1;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Инициализация доступного количества купюр
        int count50 = 5;   // Количество купюр по 50 рублей
        int count100 = 5;  // Количество купюр по 100 рублей
        int count1000 = 5; // Количество купюр по 1000 рублей

        int s = -1;

        // Ввод запрашиваемой суммы
        while (s <= 0) {
            System.out.print("Введите сумму для снятия (положительное число): ");
            if (scanner.hasNextInt()) {
                s = scanner.nextInt();
                if (s <= 0) {
                    System.out.println("Ошибка: сумма должна быть положительной.");
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next(); // Очищаем неверный ввод
            }
        }

        // Начинаем выдачу денег
        int originalAmount = s; // Сохраняем оригинальную сумму для вывода

        int notes1000 = 0;
        int notes100 = 0;
        int notes50 = 0;

        // Выдача купюр
        if (s >= 1000 && count1000 > 0) {
            notes1000 = Math.min(s / 1000, count1000);
            s -= notes1000 * 1000;
        }

        if (s >= 100 && count100 > 0) {
            notes100 = Math.min(s / 100, count100);
            s -= notes100 * 100;
        }

        if (s >= 50 && count50 > 0) {
            notes50 = Math.min(s / 50, count50);
            s -= notes50 * 50;
        }

        // Проверка, выполнима ли выдача
        if (s > 0) {
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