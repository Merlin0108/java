package labStr;

import java.util.Scanner;

public class CountThreeLetterWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос на ввод предложения
        System.out.print("Введите предложение, в котором слова разделены пробелами и запятыми: ");
        String input = scanner.nextLine();

        // Проверка на пустой ввод
        if (input.trim().isEmpty()) {
            System.out.println("Ошибка: предложение не может быть пустым!");
            scanner.close();
            return;
        }

        // Проверка на наличие только допустимых символов (буквы, пробелы, запятые)
        if (!input.matches("[a-zA-Zа-яА-ЯёЁ,\\s]*")) {
            System.out.println("Ошибка: предложение может содержать только буквы, пробелы и запятые!");
            scanner.close();
            return;
        }

        // Разделение предложения на слова
        String[] words = input.split("[,\\s]+");

        // Переменная для подсчета трехбуквенных слов
        int threeLetterWordsCount = 0;

        // Подсчет трехбуквенных слов
        for (String word : words) {
            // Проверяем, что слово состоит только из букв и имеет длину 3
            if (word.length() == 3 && word.matches("[a-zA-Zа-яА-ЯёЁ]+")) {
                threeLetterWordsCount++;
            }
        }

        // Вывод результата
        System.out.println("Количество трехбуквенных слов: " + threeLetterWordsCount);

        scanner.close();
    }
}
