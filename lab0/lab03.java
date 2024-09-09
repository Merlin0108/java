package lab0;
import java.util.Scanner;
public class lab03 {
    public static void main(String[] args) {
        double meatPricePerKg = 285.5;
        double breadPricePerUnit = 25.4;
        double cucumberPricePerKg = 40.0;
        double tomatoPricePerKg = 51.0;
        double gasolinePricePerLiter = 43.6;

        Scanner scanner = new Scanner(System.in);

        // Ввод количества продуктов и бензина
        System.out.print("Введите количество мяса (кг): ");
        double meatKg = scanner.nextDouble();

        System.out.print("Введите количество хлеба (шт): ");
        int breadCount = scanner.nextInt();

        System.out.print("Введите количество огурцов (кг): ");
        double cucumberKg = scanner.nextDouble();

        System.out.print("Введите количество помидоров (кг): ");
        double tomatoKg = scanner.nextDouble();

        System.out.print("Введите количество бензина (литры): ");
        double gasolineLiters = scanner.nextDouble();

        double totalMeatCost = meatKg * meatPricePerKg;
        double totalBreadCost = breadCount * breadPricePerUnit;
        double totalCucumberCost = cucumberKg * cucumberPricePerKg;
        double totalTomatoCost = tomatoKg * tomatoPricePerKg;
        double totalGasolineCost = gasolineLiters * gasolinePricePerLiter;

        double totalCost = totalMeatCost + totalBreadCost + totalCucumberCost + totalTomatoCost + totalGasolineCost;

        double costPerPerson = totalCost / 3;


        System.out.printf("Общие расходы: %.2f руб.\n", totalCost);
        System.out.printf("Расходы на человека: %.2f руб.\n", costPerPerson);

    }
}
