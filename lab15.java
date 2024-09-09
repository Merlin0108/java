package lab1;
import java.util.Scanner;
public class lab15 {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите меньший номер билета (N): ");
    int N = scanner.nextInt();
    System.out.print("Введите больший номер билета (M): ");
    int M = scanner.nextInt();

    if (N < 0 || M < 0 || N > 999999 || M > 999999 || N > M) {
        System.out.println("Ошибка: Неверные значения для N или M. " +
                "Они должны быть шестизначными числами и N должно быть меньше или равно M.");
        return;
    }

    int happyTicketCount = 0;

    for (int ticket = N; ticket <= M; ticket++) {
        if (isHappyTicket(ticket)) {
            happyTicketCount++;
        }
    }

    System.out.println("Количество счастливых билетов на катушке: " + happyTicketCount);
}

    private static boolean isHappyTicket(int ticket) {
        String ticketStr = String.format("%06d", ticket);
        int sumFirstHalf = Character.getNumericValue(ticketStr.charAt(0)) +
                Character.getNumericValue(ticketStr.charAt(1)) +
                Character.getNumericValue(ticketStr.charAt(2));

        int sumSecondHalf = Character.getNumericValue(ticketStr.charAt(3)) +
                Character.getNumericValue(ticketStr.charAt(4)) +
                Character.getNumericValue(ticketStr.charAt(5));

        return sumFirstHalf == sumSecondHalf;
    }
}
