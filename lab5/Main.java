package lab5;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создание списка школьников
        ArrayList<Shkolnik> shkolniki = new ArrayList<>();
        shkolniki.add(new Shkolnik("Аня", "женский", 15, new int[]{5, 5, 5, 4}, new boolean[]{true, false, true}));
        shkolniki.add(new Shkolnik("Маша", "женский", 16, new int[]{5, 4, 5, 4}, new boolean[]{true, true, false}));

        // Вывод информации о девочках, получивших первые места на олимпиадах
        System.out.println("Девочки, получившие первые места на олимпиадах:");
        for (Shkolnik shkolnik : shkolniki) {
            if (shkolnik.getGender().equals("женский") && shkolnik.hasFirstPlaceInOlympiad()) {
                shkolnik.printInfo();
            }
        }

        // Создание списка студентов
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Петя", "мужской", 20, new double[]{5, 4, 5, 5}, new double[]{5, 5}));
        students.add(new Student("Иван", "мужской", 21, new double[]{4, 3, 5}, new double[]{}));

        // Вывод информации о студентах с оценками за курсовые работы
        System.out.println("\nСтуденты с оценками за курсовые работы:");
        for (Student student : students) {
            if (student.courseWorkGrades.length > 0) {
                student.printInfo();
            }
        }

        // Общий список школьников и студентов, которые должны получать специальную стипендию
        System.out.println("\nКандидаты на специальную стипендию:");
        ArrayList<Uchashchysya> scholarshipCandidates = new ArrayList<>();
        for (Shkolnik shkolnik : shkolniki) {
            if (shkolnik.isEligibleForScholarship()) {
                scholarshipCandidates.add(shkolnik);
            }
        }
        for (Student student : students) {
            if (student.isEligibleForScholarship()) {
                scholarshipCandidates.add(student);
            }
        }

        for (Uchashchysya candidate : scholarshipCandidates) {
            candidate.printInfo();
        }
    }
}