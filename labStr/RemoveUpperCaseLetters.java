package labStr;

import java.util.Scanner;

public class RemoveUpperCaseLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите слово: ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Ошибка: введено пустое слово. Пожалуйста, введите непустое слово.");
            return;
        }

        StringBuilder result = new StringBuilder();

        boolean hasLetters = false;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                hasLetters = true;

                if (!Character.isUpperCase(ch)) {
                    result.append(ch);
                }
            } else if (!Character.isWhitespace(ch)) {
                System.out.println("Ошибка: введены недопустимые символы. Используйте только буквы.");
                return;
            }
        }

        if (!hasLetters) {
            System.out.println("Ошибка: введенное слово не содержит букв.");
            return;
        }

        System.out.println("Результат: " + result.toString());

        // Закрываем сканер
        scanner.close();
    }
}
