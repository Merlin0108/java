package lab2;
import java.util.Random;

public class MaxEvenNumber {

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

        int maxEven = Integer.MIN_VALUE;
        boolean foundEven = false;

        for (int num : numbers) {
            if (num % 2 == 0) {
                foundEven = true;
                if (num > maxEven) {
                    maxEven = num;
                }
            }
        }

        if (foundEven) {
            System.out.println("Максимальное четное число: " + maxEven);
        } else {
            System.out.println("В массиве нет четных чисел.");
        }
    }
}