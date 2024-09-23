package lab1;

import java.util.Scanner;

public class LuckyTickets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min = -1;
        int max = -1;

        while (min < 0 || min > 999999) {
            System.out.print("Введите меньший номер билета (0 - 999999): ");
            if (scanner.hasNextInt()) {
                min = scanner.nextInt();
                if (min < 0 || min > 999999) {
                    System.out.println("Ошибка: номер билета должен быть от 0 до 999999.");
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }

        while (max <= min || max > 999999) {
            System.out.print("Введите больший номер билета (больше " + min + " и до 999999): ");
            if (scanner.hasNextInt()) {
                max = scanner.nextInt();
                if (max <= min || max > 999999) {
                    System.out.println("Ошибка: номер билета должен быть больше " + min + " и до 999999.");
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }
        scanner.close();

        int luckyCount = 0;

        for (int i = min; i <= max; i++) {
            if (isLuckyTicket(i)) {
                luckyCount++;
            }
        }

        System.out.println("Количество счастливых билетов на катушке: " + luckyCount);
    }

    private static boolean isLuckyTicket(int ticketNumber) {
        String ticketStr = String.format("%06d", ticketNumber);

        int sumFirstHalf = Character.getNumericValue(ticketStr.charAt(0)) +
                Character.getNumericValue(ticketStr.charAt(1)) +
                Character.getNumericValue(ticketStr.charAt(2));

        int sumSecondHalf = Character.getNumericValue(ticketStr.charAt(3)) +
                Character.getNumericValue(ticketStr.charAt(4)) +
                Character.getNumericValue(ticketStr.charAt(5));

        return sumFirstHalf == sumSecondHalf;
    }
}