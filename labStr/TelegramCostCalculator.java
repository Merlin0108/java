package labStr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelegramCostCalculator {

    public static void main(String[] args) {
        // Считывание строки
        String telegramText = readInput();

        // Обработка текста телеграммы
        Result result = processTelegram(telegramText);

        // Вывод результата
        System.out.println("Стоимость телеграммы: " + result.getCost() + " руб.");
        System.out.println("Преобразованный текст: " + result.getProcessedText());
    }

    private static String readInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст телеграммы (или имя файла для чтения):");
        String input = scanner.nextLine();

        // Проверка, является ли вводом имя файла
        if (input.endsWith(".txt")) {
            StringBuilder fileContent = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    fileContent.append(line).append("\n");
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return fileContent.toString().trim();
        }
        return input;
    }

    private static Result processTelegram(String text) {
        String[] words = text.split("[\\s,]+");
        List<String> processedWords = new ArrayList<>();
        int cost = 0;

        for (String word : words) {
            // Проверка на предлог (слово длиной 1 или 2 символа)
            if (word.length() <= 2) {
                continue; // Игнорируем предлоги
            }

            // Если слово - запятая, заменяем на 'зпт'
            if (word.equals(",")) {
                processedWords.add("зпт"); // Можно заменить на "zpt" или "comma"
            } else {
                processedWords.add(word);
                cost += 10; // Каждое слово (кроме предлогов) стоит 10 рублей
            }
        }

        String processedText = String.join(" ", processedWords);
        return new Result(cost, processedText);
    }
}

class Result {
    private final int cost;
    private final String processedText;

    public Result(int cost, String processedText) {
        this.cost = cost;
        this.processedText = processedText;
    }

    public int getCost() {
        return cost;
    }

    public String getProcessedText() {
        return processedText;
    }
}

