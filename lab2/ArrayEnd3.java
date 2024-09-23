package lab2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ArrayEnd3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Создаем массив и заполняем его случайными числами
        int[] originalArray = new int[20];
        System.out.println("Сгенерированный массив:");
        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = random.nextInt(1000) + 1; // Диапазон от 1 до 1000
            System.out.print(originalArray[i] + " ");
        }
        System.out.println();

        // Создаем новый массив, добавляя в него числа, заканчивающиеся на цифру 3
        ArrayList<Integer> filteredList = new ArrayList<>();
        for (int num : originalArray) {
            if (num % 10 == 3) {
                filteredList.add(num);
            }
        }

        // Сортируем новый массив по убыванию
        Collections.sort(filteredList, Collections.reverseOrder());

        // Преобразуем список в массив, если он не пустой
        if (!filteredList.isEmpty()) {
            Integer[] sortedArray = filteredList.toArray(new Integer[0]);
            System.out.println("Отсортированный массив (элементы, оканчивающиеся на 3):");
            for (int num : sortedArray) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("Нет элементов, оканчивающихся на 3.");
        }
    }
}