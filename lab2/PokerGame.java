package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PokerGame {
    private static final int MAX_PLAYERS = 10; // Максимальное количество игроков
    private static final int CARDS_PER_PLAYER = 5; // Количество карт на игрока

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем количество игроков
        int numberOfPlayers;
        while (true) {
            System.out.print("Введите количество игроков (от 1 до " + MAX_PLAYERS + "): ");
            numberOfPlayers = scanner.nextInt();
            if (numberOfPlayers >= 1 && numberOfPlayers <= MAX_PLAYERS) {
                break; // Введено корректное количество игроков
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до " + MAX_PLAYERS + ".");
            }
        }

        // Создаем колоду карт
        List<String> deck = createDeck();
        // Перемешиваем колоду
        Collections.shuffle(deck);

        // Раздаем карты игрокам
        for (int i = 0; i < numberOfPlayers; i++) {
            List<String> playerHand = dealCards(deck, i);
            System.out.println("Игрок " + (i + 1) + ": " + playerHand);
        }

        // Закрываем сканер
        scanner.close();
    }

    // Метод для создания колоды карт
    private static List<String> createDeck() {
        List<String> deck = new ArrayList<>();
        String[] suits = {"Черви", "Бубны", "Трефы", "Пики"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " " + suit);
            }
        }
        return deck;
    }

    // Метод для раздачи карт
    private static List<String> dealCards(List<String> deck, int playerIndex) {
        List<String> hand = new ArrayList<>();
        for (int i = 0; i < CARDS_PER_PLAYER; i++) {
            hand.add(deck.remove(deck.size() - 1)); // Берем последнюю карту из колоды
        }
        return hand;
    }
}