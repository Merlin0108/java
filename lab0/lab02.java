package lab0;
import java.util.Scanner;
public class lab02 {
    public static void main(String[] args) {
        String[] companies = {"Витражи", "Стекольщик", "Мастер"};
        double[] glassPrices = {420.0, 440.0, 470.0};
        double[] cuttingAndGrindingCosts = {75.0, 65.0, 55.0};

        final double glassArea = 0.25;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество заказываемых стекол: ");
        int quantity = scanner.nextInt();

        double[] totalCosts = new double[companies.length];

        for (int i = 0; i < companies.length; i++) {
            double glassCost = glassPrices[i] * glassArea * quantity;
            double totalCost = glassCost + (cuttingAndGrindingCosts[i] * quantity);
            totalCosts[i] = totalCost;
        }

        double minCost = totalCosts[0];
        String bestCompany = companies[0];
        for (int i = 1; i < totalCosts.length; i++) {
            if (totalCosts[i] < minCost) {
                minCost = totalCosts[i];
                bestCompany = companies[i];
            }
        }
        System.out.printf("Самый дешевый заказ у компании %s: %.2f рублей\n", bestCompany, minCost);
    }
}
