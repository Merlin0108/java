package lab1;
import java.util.Scanner;
public class lab14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество этажей (N): ");
        int N = scanner.nextInt();

        System.out.print("Введите номер квартиры (M): ");
        int M = scanner.nextInt();

        if (N <= 0 || M <= 0 || M > N * 3) {
            System.out.println("Ошибка: Неверные значения для N или M.");
            return;
        }
        int floorNumber = (M - 1) / 3 + 1;

        if (floorNumber % 2 == 0) {
            floorNumber--;
        }

        if (floorNumber > N) {
            floorNumber = N % 2 == 0 ? N - 1 : N;
        }

        System.out.println("Лифт доставит вас на этаж: " + floorNumber);
    }
}
