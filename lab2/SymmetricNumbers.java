package lab2;
import java.util.Random;

public class SymmetricNumbers {

    public static void main(String[] args) {
        // Создаем массив на 20 целых чисел
        int[] numbers = new int[20];
        Random random = new Random();

        // Заполняем массив случайными числами от 0 до 1000
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1001); // Генерируем числа от 0 до 1000
        }

        // Выводим заполненный массив
        System.out.println("Сгенерированный массив:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Переменные для подсчета суммы и количества симметричных чисел
        int count = 0;
        int sum = 0;

        // Проверяем каждое число в массиве
        for (int num : numbers) {
            if (isThreeDigitSymmetric(num)) {
                count++;
                sum += num;
            }
        }

        // Выводим результаты
        System.out.println("Количество трехзначных симметричных чисел: " + count);
        System.out.println("Сумма трехзначных симметричных чисел: " + sum);
    }

    // Метод для проверки, является ли число трехзначным симметричным
    private static boolean isThreeDigitSymmetric(int num) {
        if (num < 100 || num > 999) {
            return false; // Проверяем, что число трехзначное
        }
        int hundreds = num / 100; // Сотни
        int tens = (num / 10) % 10; // Десятки
        int units = num % 10; // Единицы

        return hundreds == units; // Проверяем, что сотни равны единицам
    }
}