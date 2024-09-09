package lab0;
import java.util.Scanner;
public class lab04 {
    public static void main(String[] args) {
        final double PAY_AS_YOU_GO_SUBSCRIPTION = 135;
        final double PAY_AS_YOU_GO_RATE = 0.3;
        final double COMBINED_SUBSCRIPTION = 255;
        final double COMBINED_MINUTES_LIMIT = 450;
        final double COMBINED_EXTRA_RATE = 0.28;
        final double UNLIMITED_SUBSCRIPTION = 380;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите общую длительность телефонных разговоров за месяц (в минутах): ");
        double totalMinutes = scanner.nextDouble();

        double payAsYouGoCost = PAY_AS_YOU_GO_SUBSCRIPTION + (totalMinutes * PAY_AS_YOU_GO_RATE);
        double combinedCost;

        if (totalMinutes <= COMBINED_MINUTES_LIMIT) {
            combinedCost = COMBINED_SUBSCRIPTION;
        } else {
            combinedCost = COMBINED_SUBSCRIPTION + ((totalMinutes - COMBINED_MINUTES_LIMIT) * COMBINED_EXTRA_RATE);
        }

        double unlimitedCost = UNLIMITED_SUBSCRIPTION;

        String bestTariff;
        double minCost = payAsYouGoCost;

        if (combinedCost < minCost) {
            bestTariff = "Комбинированный тариф";
            minCost = combinedCost;
        } else {
            bestTariff = "Помесячный тариф";
        }

        if (unlimitedCost < minCost) {
            bestTariff = "Безлимитный тариф";
        }

        System.out.printf("Стоимость по повременному тарифу: %.2f руб.\n", payAsYouGoCost);
        System.out.printf("Стоимость по комбинированному тарифу: %.2f руб.\n", combinedCost);
        System.out.printf("Стоимость по безлимитному тарифу: %.2f руб.\n", unlimitedCost);
        System.out.printf("Наиболее выгодный тариф: %s\n", bestTariff);

    }
}
