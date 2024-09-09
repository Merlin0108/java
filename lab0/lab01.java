package lab0;
import java.util.Scanner;

public class lab01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double originalPrice = 0;
        double discountRate = 0.13;
        System.out.print("Введите цену товара: ");
        originalPrice = scanner.nextDouble();

        double discountAmount = originalPrice * discountRate;
        double discountedPrice = originalPrice - discountAmount;
        System.out.printf("Цена товара со скидкой составляет: %.2f\n", discountedPrice);

    }
}
