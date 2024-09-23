package lab2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayEnd3 {
    public static void main(String[] args) {
        Random random = new Random();

        int[] originalArray = new int[20];
        System.out.println("Сгенерированный массив:");
        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = random.nextInt(1000) + 1;
            System.out.print(originalArray[i] + " ");
        }
        System.out.println();

        ArrayList<Integer> filteredList = new ArrayList<>();
        for (int num : originalArray) {
            if (num % 10 == 3) {
                filteredList.add(num);
            }
        }

        Collections.sort(filteredList, Collections.reverseOrder());

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