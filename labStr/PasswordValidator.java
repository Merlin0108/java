package labStr;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос на ввод пароля
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        // Проверка длины пароля
        if (password.length() < 8 || password.length() > 12) {
            System.out.println("Ошибка: Длина пароля должна быть от 8 до 12 символов.");
        }
        // Проверка наличия хотя бы одной заглавной буквы
        else if (!password.matches(".*[A-Z].*")) {
            System.out.println("Ошибка: Пароль должен содержать хотя бы одну заглавную латинскую букву.");
        }
        // Проверка наличия хотя бы одной строчной буквы
        else if (!password.matches(".*[a-z].*")) {
            System.out.println("Ошибка: Пароль должен содержать хотя бы одну строчную латинскую букву.");
        }
        // Проверка наличия хотя бы одного специального символа
        else if (!password.matches(".*[#$%^&*<>].*")) {
            System.out.println("Ошибка: Пароль должен содержать хотя бы один из специальных символов: #, @, $, %, ^, &, *, <, >.");
        }
        // Проверка наличия хотя бы одного знака препинания
        else if (!password.matches(".*[.,;!?].*")) {
            System.out.println("Ошибка: Пароль должен содержать хотя бы один знак препинания (например, ., ;, !, ?).");
        }
        // Если все проверки пройдены успешно
        else {
            System.out.println("Пароль хороший!");
        }

        scanner.close();
    }
}
