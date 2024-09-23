package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PokerGame {
    private static final int MAX_PLAYERS = 10;
    private static final int CARDS_PER_PLAYER = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlayers;
        while (true) {
            System.out.print("Введите количество игроков (от 1 до " + MAX_PLAYERS + "): ");
            numberOfPlayers = scanner.nextInt();
            if (numberOfPlayers >= 1 && numberOfPlayers <= MAX_PLAYERS) {
                break;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до " + MAX_PLAYERS + ".");
            }
        }

        List<String> deck = createDeck();
        Collections.shuffle(deck);

        for (int i = 0; i < numberOfPlayers; i++) {
            List<String> playerHand = dealCards(deck, i);
            System.out.println("Игрок " + (i + 1) + ": " + playerHand);
        }

        scanner.close();
    }

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

    private static List<String> dealCards(List<String> deck, int playerIndex) {
        List<String> hand = new ArrayList<>();
        for (int i = 0; i < CARDS_PER_PLAYER; i++) {
            hand.add(deck.remove(deck.size() - 1));
        }
        return hand;
    }
}