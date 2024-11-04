package indiv1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EventCalendar {
    private static List<Event> events = new ArrayList<>();

    public static void main(String[] args) {
        String filename = "C:/Users/micha/IdeaProjects/untitled1/java/indiv1/1.txt"; // имя вашего файла с событиями
        loadEventsFromFile(filename);
        processEvents();
        displayEvents();
        queryEventsByDate();
    }

    private static void loadEventsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // пропуск пустых строк
                String[] parts = line.split(",");
                if (parts.length < 3) {
                    System.out.println("Неправильный формат строки: " + line);
                    continue;
                }

                String name = parts[0].trim();
                LocalDateTime startTime;
                double durationHours;
                try {
                    startTime = LocalDateTime.parse(parts[1].trim(), formatter);
                    durationHours = Double.parseDouble(parts[2].trim());
                } catch (Exception e) {
                    System.out.println("Ошибка при парсинге данных: " + line);
                    continue;
                }

                LocalDateTime endTime = startTime.plusHours((long) durationHours)
                        .plusMinutes((long) ((durationHours % 1) * 60));
                String type = getTypeFromUser(name);

                // Проверка на пересечение
                if (!isEventValid(startTime, endTime, type)) {
                    System.out.println("Событие \"" + name + "\" недопустимо, не подходит по времени.");
                    continue;
                }

                if (type != null) {
                    Event event = new Event(name, startTime, endTime, type);
                    if (!checkForOverlaps(event)) {
                        events.add(event);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private static boolean isEventValid(LocalDateTime startTime, LocalDateTime endTime, String type) {
        int dayOfWeek = startTime.getDayOfWeek().getValue();

        if (type.equals("work")) {
            // Для рабочих событий: Пн-Пт с 9 до 18
            return dayOfWeek >= 1 && dayOfWeek <= 5 && startTime.getHour() >= 9 && endTime.getHour() <= 18;
        } else if (type.equals("personal")) {
            // Для личных событий: Воскресенье-Четверг до 23:00 и не заходить на следующий день
            if (dayOfWeek >= 1 && dayOfWeek <= 4) { // Пн-Чт
                return (startTime.getHour() >= 18 && startTime.getHour() < 23 && endTime.getHour() < 24);
            } else if (dayOfWeek == 5 || dayOfWeek == 6) { // Пятница и Суббота
                return (startTime.getHour() >= 0 && startTime.getHour() < 9) || (startTime.getHour() >= 18);
            }
              else if (dayOfWeek == 6) { // Пятница и Суббота
                return (startTime.getHour() >= 0) || (startTime.getHour() >= 24);
            }
              else if (dayOfWeek == 7) { // Воскресенье
                return (startTime.getHour() >= 0 && startTime.getHour() < 23 && endTime.getHour() < 24);
            }
        }
        return false; // Не попадает под допустимые условия
    }

    private static String getTypeFromUser(String eventName) {
        Scanner scanner = new Scanner(System.in);
        String type = null;
        while (type == null) {
            System.out.print("Введите тип события для \"" + eventName + "\" (work/personal): ");
            type = scanner.nextLine().trim();
            if (!type.equals("work") && !type.equals("personal")) {
                System.out.println("Недопустимый тип события. Пожалуйста, введите 'work' или 'personal'.");
                type = null; // сбрасываем, чтобы повторить ввод
            }
        }
        return type;
    }

    private static boolean checkForOverlaps(Event newEvent) {
        for (Event existingEvent : events) {
            if (existingEvent.overlapsWith(newEvent)) {
                Scanner scanner = new Scanner(System.in);
                int choice = 0;
                boolean validChoice = false;

                while (!validChoice) {
                    System.out.print("Событие \"" + newEvent.getName() + "\" пересекается с \"" + existingEvent.getName() + "\". Хотите (1) отказаться или (2) заменить все пересекающиеся события? ");
                    try {
                        choice = scanner.nextInt();
                        if (choice == 1 || choice == 2) {
                            validChoice = true;
                        } else {
                            System.out.println("Недопустимый выбор. Пожалуйста, введите 1 или 2.");
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка ввода. Пожалуйста, введите 1 или 2.");
                        scanner.next(); // очищаем неверный ввод
                    }
                }

                if (choice == 1) {
                    System.out.println("Событие \"" + newEvent.getName() + "\" будет пропущено.");
                    return true; // Пропускаем событие
                } else if (choice == 2) {
                    System.out.println("Событие \"" + existingEvent.getName() + "\" будет удалено.");
                    events.remove(existingEvent);
                    // Продолжить проверку, так как могут быть другие пересечения
                    return checkForOverlaps(newEvent);
                }
            }
        }
        return false; // Нет пересечений
    }

    private static void processEvents() {
        events.sort(Comparator.comparing(Event::getStartTime));
    }

    private static void displayEvents() {
        System.out.println("\nКалендарь событий:");
        for (Event event : events) {
            System.out.println(event);
        }
    }

    private static void queryEventsByDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату для запроса событий (формат: yyyy-MM-dd): ");
        String date = scanner.nextLine().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDateTime queryDate = LocalDateTime.parse(date + "T00:00:00", formatter);

            System.out.println("\nСобытия на " + date + ":");
            for (Event event : events) {
                if (event.getStartTime().toLocalDate().isEqual(queryDate.toLocalDate())) {
                    System.out.println(event);
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при парсинге даты: " + e.getMessage());
        }
    }
}
