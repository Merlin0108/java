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

        // Ввод года пользователем
        System.out.print("Введите год: ");

        // Проверка на корректность ввода
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите целое число.");
            return;
        }

        int year = scanner.nextInt();

        // Проверка на корректность года
        if (year < 0) {
            System.out.println("Ошибка: год должен быть положительным.");
            return;
        }

        // Вычисляем индекс животного в 12-летнем цикле
        // 1996 год — это год Крысы
        int index = (year - 1996) % 12;

        // Если индекс отрицательный, сдвигаем его в положительную область
        if (index < 0) {
            index += 12;
        }

        // Вывод названия животного
        System.out.println("Год " + year + " — это год " + ANIMALS[index] + ".");
    }
}
