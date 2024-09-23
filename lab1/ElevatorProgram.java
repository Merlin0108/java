package lab1;

import java.util.Scanner;
public class ElevatorProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int floors = 0;
        while (true) {
            System.out.print("Введите количество этажей (положительное целое число): ");
            if (scanner.hasNextInt()) {
                floors = scanner.nextInt();
                if (floors > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: количество этажей должно быть положительным.");
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }

        int M = 0;
        while (true) {
            System.out.print("Введите номер квартиры (положительное целое число от 1 до " + (floors * 3) + "): ");
            if (scanner.hasNextInt()) {
                M = scanner.nextInt();
                if (M > 0 && M <= floors * 3) {
                    break;
                } else {
                    System.out.println("Ошибка: номер квартиры должен быть в пределах от 1 до " + (floors * 3) + ".");
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }
        scanner.close();

        int apartmentIndex = M - 1;
        int floor = (apartmentIndex / 3) + 1;

        if (floor % 2 == 0) {
            floor++;
        }

        if (floor > floors) {
            System.out.println("Ошибка: лифт не может поднять на этаж " + floor + ". Наибольший этаж " + floors + ".");
        } else {
            System.out.println("Лифт доставит вас на этаж " + floor + ".");
        }
    }
}
