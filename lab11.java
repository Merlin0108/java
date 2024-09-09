package lab1;
import java.util.Scanner;
public class lab11 {
    public static void main(String[] args) {
        String[] animals = {
                "Крысы", "Коровы", "Тигра", "Зайца", "Дракона",
                "Змеи", "Лошади", "Овцы", "Обезьяны", "Курицы",
                "Собаки", "Свиньи"
        };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        int cycleYear = (year - 1996) % 12;
        if (cycleYear < 0) {
            cycleYear += 12;
        }

        String animalName = animals[cycleYear];

        System.out.println(year + "- год " + animalName);

    }

}
