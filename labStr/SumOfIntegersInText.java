package labStr;

import java.util.Scanner;

public class SumOfIntegersInText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос на ввод текста
        System.out.print("Введите текст: ");
        String input = scanner.nextLine();

        // Проверка на пустой ввод
        if (input.trim().isEmpty()) {
            System.out.println("Ошибка: текст не может быть пустым!");
            scanner.close();
            return;
        }

        // Инициализация переменной для хранения суммы
        int sum = 0;

        // Разделение текста на части по нецифровым символам
        String[] numbers = input.split("[^0-9-]+");  // регулярное выражение для разделения по всему, что не является цифрой или минусом

        // Подсчет суммы целых чисел
        for (String numStr : numbers) {
            if (!numStr.isEmpty()) {
                try {
                    // Преобразуем строку в целое число и добавляем к сумме
                    sum += Integer.parseInt(numStr);
                } catch (NumberFormatException e) {
                    // Если строка не может быть преобразована в число, игнорируем ее
                    continue;
                }
            }
        }

        // Вывод результата
        System.out.println("Сумма всех целых чисел в тексте: " + sum);

        scanner.close();
    }
}
