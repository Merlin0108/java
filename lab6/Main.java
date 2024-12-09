package lab6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Yuchashchiy> candidates = new ArrayList<>();

        // Создание и добавление школьников
        try {
            candidates.add(new Shkolnik("Алексей", "Иванов", 15, new int[]{5, 4, 5, 4}, 1));
            candidates.add(new Shkolnik("Мария", "Петрова", 16, new int[]{4, 5, 5, 5}, 2));
            candidates.add(new Shkolnik("Светлана", "Сидорова", 14, new int[]{5, 4, 5, 5}, 1));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка добавления школьника: " + e.getMessage());
        }

        // Создание и добавление студентов
        try {
            candidates.add(new Student("Иван", "Смирнов", 20, new int[]{5, 4, 3}, new int[]{5, 5}));
            candidates.add(new Student("Ольга", "Кузнецова", 19, new int[]{4, 4, 4}, new int[]{5, 5}));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка добавления студента: " + e.getMessage());
        }

        // Сортировка по фамилиям
        Collections.sort(candidates);
        System.out.println("Кандидаты на специальную стипендию (отсортированы по фамилии):");
        for (Yuchashchiy candidate : candidates) {
            System.out.println(candidate.getSurname() + " " + candidate.getName() +
                    ", Средний балл: " + candidate.getAverageGrade());
        }

        // Поиск лучшего школьника и студента
        Yuchashchiy bestShkolnik = null;
        Yuchashchiy bestStudent = null;

        for (Yuchashchiy candidate : candidates) {
            if (candidate instanceof Shkolnik) {
                if (bestShkolnik == null || candidate.getAverageGrade() > bestShkolnik.getAverageGrade()) {
                    bestShkolnik = candidate;
                }
            } else if (candidate instanceof Student) {
                if (bestStudent == null || candidate.getAverageGrade() > bestStudent.getAverageGrade()) {
                    bestStudent = candidate;
                }
            }
        }

        if (bestShkolnik != null) {
            System.out.println("\nЛучший школьник: " + bestShkolnik.getName() + " " + bestShkolnik.getSurname() +
                    ", Средний балл: " + bestShkolnik.getAverageGrade());
        }
        if (bestStudent != null) {
            System.out.println("Лучший студент: " + bestStudent.getName() + " " + bestStudent.getSurname() +
                    ", Средний балл: " + bestStudent.getAverageGrade());
        }

        // Сортировка школьников по рейтингу успеваемости и номеру школы
        ArrayList<Shkolnik> shkolniki = new ArrayList<>();
        for (Yuchashchiy candidate : candidates) {
            if (candidate instanceof Shkolnik) {
                shkolniki.add((Shkolnik) candidate);
            }
        }

        Collections.sort(shkolniki, Comparator.comparingDouble(Shkolnik::getAverageGrade)
                .thenComparing(Shkolnik::getSchoolNumber));

        System.out.println("\nШкольники, отсортированные по успеваемости и номеру школы:");
        for (Shkolnik shkolnik : shkolniki) {
            System.out.println(shkolnik.getSurname() + " " + shkolnik.getName() +
                    ", Средний балл: " + shkolnik.getAverageGrade() + ", Номер школы: " + shkolnik.getSchoolNumber());
        }

        // Сортировка студентов по рейтингу успеваемости
        ArrayList<Student> students = new ArrayList<>();
        for (Yuchashchiy candidate : candidates) {
            if (candidate instanceof Student) {
                students.add((Student) candidate);
            }
        }

        Collections.sort(students, Comparator.comparingDouble(Student::getAverageGrade).reversed());

        System.out.println("\nСтуденты, отсортированные по успеваемости:");
        for (Student student : students) {
            System.out.println(student.getSurname() + " " + student.getName() +
                    ", Средний балл: " + student.getAverageGrade());
        }
    }
}