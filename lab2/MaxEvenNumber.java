package lab2;
import java.util.Random;

public class MaxEvenNumber {

    public static void main(String[] args) {
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

        // Находим максимальное четное число
        int maxEven = Integer.MIN_VALUE; // Начальное значение для максимального четного числа
        boolean foundEven = false; // Флаг для проверки, найдено ли четное число

        for (int num : numbers) {
            if (num % 2 == 0) { // Проверяем, является ли число четным
                foundEven = true; // Устанавливаем флаг в true, если нашли четное число
                if (num > maxEven) {
                    maxEven = num; // Обновляем максимальное четное число
                }
            }
        }

        // Выводим результат
        if (foundEven) {
            System.out.println("Максимальное четное число: " + maxEven);
        } else {
            System.out.println("В массиве нет четных чисел.");
        }
    }
}