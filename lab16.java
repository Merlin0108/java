package lab1;
import java.util.Scanner;
public class lab16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество купюр достоинством 50 рублей: ");
        int count50 = scanner.nextInt();
        System.out.print("Введите количество купюр достоинством 100 рублей: ");
        int count100 = scanner.nextInt();
        System.out.print("Введите количество купюр достоинством 1000 рублей: ");
        int count1000 = scanner.nextInt();

        System.out.print("Введите сумму, которую необходимо выдать: ");
        int s = scanner.nextInt();

        if (s % 50 != 0) {
            System.out.println("Ошибка: Сумма должна быть кратна 50.");
            return;
        }

        int num1000 = 0, num100 = 0, num50 = 0;

        while (s > 0) {
            if (s >= 1000 && count1000 > 0) {
                int billCount = Math.min(s / 1000, count1000);
                s -= billCount * 1000;
                num1000 += billCount;
                count1000 -= billCount;
            } else if (s >= 100 && count100 > 0) {
                int billCount = Math.min(s / 100, count100);
                s -= billCount * 100;
                num100 += billCount;
                count100 -= billCount;
            } else if (s >= 50 && count50 > 0) {
                int billCount = Math.min(s / 50, count50);
                s -= billCount * 50;
                num50 += billCount;
                count50 -= billCount;
            } else {
                break;
            }
        }

        if (s > 0) {
            System.out.println("Ошибка: Невозможно выдать запрашиваемую сумму.");
        } else {
            System.out.println("Выданные купюры:");
            if (num1000 > 0) {
                System.out.println(num1000 + " купюр по 1000 рублей");
            }
            if (num100 > 0) {
                System.out.println(num100 + " купюр по 100 рублей");
            }
            if (num50 > 0) {
                System.out.println(num50 + " купюр по 50 рублей");
            }
        }
    }
}
