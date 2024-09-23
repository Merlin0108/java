package lab1;

import java.util.Scanner;
public class ElevatorProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод кол-ва этажей
        int N = 0;
        while (true) {
            System.out.print("Введите количество этажей (положительное целое число): ");
            if (scanner.hasNextInt()) {
                N = scanner.nextInt();
                if (N > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: количество этажей должно быть положительным.");
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next(); // Очищаем неверный ввод
            }
        }

        // Ввод номера квартиры
        int M = 0;
        while (true) {
            System.out.print("Введите номер квартиры (положительное целое число от 1 до " + (N * 3) + "): ");
            if (scanner.hasNextInt()) {
                M = scanner.nextInt();
                if (M > 0 && M <= N * 3) {
                    break;
                } else {
                    System.out.println("Ошибка: номер квартиры должен быть в пределах от 1 до " + (N * 3) + ".");
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next(); // Очищаем неверный ввод
            }
        }

        // Определение этажа
        int apartmentIndex = M - 1; // Индекс квартиры начинается с 0
        int floor = (apartmentIndex / 3) + 1; // Номер этажа (по 3 квартиры на этаж)

        // Лифт останавливается только на нечётных этажах
        if (floor % 2 == 0) {
            floor++; // Если этаж чётный, поднимаемся на следующий нечётный этаж
        }

        // Убедимся, что этаж не превышает максимально допустимый
        if (floor > N) {
            System.out.println("Ошибка: лифт не может поднять на этаж " + floor + ". Наибольший этаж " + N + ".");
        } else {
            System.out.println("Лифт доставит вас на этаж " + floor + ".");
        }
    }
}
