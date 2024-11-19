package labStr;

import java.util.Scanner;

public class DecryptMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос на ввод сообщения
        System.out.print("Введите зашифрованное сообщение: ");
        String input = scanner.nextLine();

        // Проверка на пустую строку
        if (input.trim().isEmpty()) {
            System.out.println("Ошибка: сообщение не может быть пустым!");
            scanner.close();
            return;
        }

        // Проверка на наличие недопустимых символов (например, цифры или спецсимволы)
        if (!input.matches("[a-zA-Zа-яА-ЯёЁ\\s]*")) {
            System.out.println("Ошибка: сообщение может содержать только буквы и пробелы!");
            scanner.close();
            return;
        }

        // Разделяем сообщение на слова
        String[] words = input.split(" ");

        StringBuilder decryptedMessage = new StringBuilder();

        // Процесс расшифровки (реверс слов)
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            decryptedMessage.append(reversedWord.reverse().toString()).append(" ");
        }

        // Вывод расшифрованного сообщения
        System.out.println("Расшифрованное сообщение: " + decryptedMessage.toString().trim());

        scanner.close();
    }
}
