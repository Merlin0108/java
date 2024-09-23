package lab2;
import java.util.Random;

public class SymmetricNumbers {

    public static void main(String[] args) {
        int[] numbers = new int[20];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1001);
        }

        System.out.println("Сгенерированный массив:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        int count = 0;
        int sum = 0;

        for (int num : numbers) {
            if (isThreeDigitSymmetric(num)) {
                count++;
                sum += num;
            }
        }

        System.out.println("Количество трехзначных симметричных чисел: " + count);
        System.out.println("Сумма трехзначных симметричных чисел: " + sum);
    }

    private static boolean isThreeDigitSymmetric(int num) {
        if (num < 100 || num > 999) {
            return false;
        }
        int hundreds = num / 100;
        int units = num % 10;

        return hundreds == units;
    }
}