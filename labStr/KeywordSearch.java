package labStr;

import java.util.*;
import java.util.regex.*;

public class KeywordSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод текста
        System.out.println("Введите текст (для завершения ввода нажмите Enter дважды):");
        StringBuilder text = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            text.append(line).append("\n");
        }

        // Ввод ключевого слова
        System.out.println("Введите ключевое слово:");
        String keyword = scanner.nextLine().trim();

        // Разделяем текст на предложения с учетом разделителей (точка, восклицательный знак, вопросительный знак)
        String[] sentences = text.toString().split("(?<=[.!?])\\s*");

        // Используем регулярное выражение для поиска целого слова
        String regex = "\\b" + Pattern.quote(keyword) + "\\b";

        // Проходим по каждому предложению и выводим те, которые содержат ключевое слово
        for (String sentence : sentences) {
            if (Pattern.compile(regex).matcher(sentence).find()) {
                System.out.println(sentence);
            }
        }
    }
}

