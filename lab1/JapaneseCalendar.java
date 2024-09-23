package lab1;

import java.util.Scanner;
public class JapaneseCalendar {
    private static final String[] ANIMALS = {
            "Крыса", "Корова", "Тигр", "Заяц", "Дракон",
            "Змея", "Лошадь", "Овца", "Обезьяна", "Курица",
            "Собака", "Свинья"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите год: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите целое число.");
            return;
        }

        int year = scanner.nextInt();

        if (year < 0) {
            System.out.println("Ошибка: год должен быть положительным.");
            return;
        }
        scanner.close();

        int index = (year - 1996) % 12;

        if (index < 0) {
            index += 12;
        }

        System.out.println("Год " + year + " — это год " + ANIMALS[index] + ".");
    }
}
