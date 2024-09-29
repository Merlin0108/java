package lab4;

public class LibraryApp {
    public static void main(String[] args) {
        Book book1 = new Book("Java 8. Полное руководство", "Г. Шилдт");
        Book book2 = new Book("Крейцерова соната", "Л. Толстой");

        Reader reader1 = new Reader("Петров", book1, 29, 3);
        Reader reader2 = new Reader("Васечкин", book2, 29, 3);

        boolean isPetrovOnTime = reader1.isBookReturnedOnTime(31, 3);

        boolean isVasechkinOnTime = reader2.isBookReturnedOnTime(24, 3);

        System.out.println(reader1.getName() + " сдал книгу вовремя: " + isPetrovOnTime);
        System.out.println(reader2.getName() + " сдал книгу вовремя: " + isVasechkinOnTime);
    }
}