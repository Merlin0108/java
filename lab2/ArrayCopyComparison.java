package lab2;
import java.util.Arrays;

public class ArrayCopyComparison {
    public static void main(String[] args) {
        // Создаем массив из миллиона строк
        int size = 1_000_000;
        String[] originalArray = new String[size];

        // Заполняем массив значениями
        for (int i = 0; i < size; i++) {
            originalArray[i] = "Строка " + i;
        }

        // Копирование вручную
        long startManual = System.nanoTime();
        String[] manualCopy = new String[size];
        for (int i = 0; i < size; i++) {
            manualCopy[i] = originalArray[i];
        }
        long endManual = System.nanoTime();

        // Копирование с использованием Arrays.copyOf
        long startArrays = System.nanoTime();
        String[] arraysCopy = Arrays.copyOf(originalArray, size);
        long endArrays = System.nanoTime();

        // Копирование с использованием System.arraycopy
        long startSystem = System.nanoTime();
        String[] systemCopy = new String[size];
        System.arraycopy(originalArray, 0, systemCopy, 0, size);
        long endSystem = System.nanoTime();

        // Выводим результаты
        System.out.println("Время копирования вручную: " + (endManual - startManual) + " нс");
        System.out.println("Время копирования с использованием Arrays.copyOf: " + (endArrays - startArrays) + " нс");
        System.out.println("Время копирования с использованием System.arraycopy: " + (endSystem - startSystem) + " нс");
    }
}