package lab5;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создание списков школьников и студентов
        ArrayList<Shkolnik> shkolniki = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        // Пример добавления школьников
        shkolniki.add(new Shkolnik("Анна", "female", 15, new int[]{5, 5, 5, 5}, true));
        shkolniki.add(new Shkolnik("Петр", "male", 14, new int[]{4, 5, 4, 5}, false));
        shkolniki.add(new Shkolnik("Мария", "female", 16, new int[]{5, 5, 4, 5}, true));

        // Пример добавления студентов
        students.add(new Student("Иван", "male", 20, new int[]{5, 4, 5, 5}, new int[]{5, 5}));
        students.add(new Student("Оля", "female", 19, new int[]{4, 4, 5, 4}, new int[]{5, 5}));

        // Вывод информации о девочках, получивших первые места на олимпиадах
        System.out.println("Девочки, получившие первые места на олимпиадах:");
        for (Shkolnik shkolnik : shkolniki) {
            if (shkolnik.isGirlWithOlympiadPrize()) {
                shkolnik.printInfo();
            }
        }

        // Вывод информации о студентах с оценками за курсовые работы
        System.out.println("\nСтуденты с оценками за курсовые работы:");
        for (Student student : students) {
            student.printInfo();
        }

        // Общий список школьников и студентов, которые должны получать специальную стипендию
        ArrayList<Yuchashchiy> scholarshipCandidates = new ArrayList<>();
        for (Shkolnik shkolnik : shkolniki) {
            if (shkolnik.hasSpecialScholarship()) {
                scholarshipCandidates.add(shkolnik);
            }
        }
        for (Student student : students) {
            if (student.hasSpecialScholarship()) {
                scholarshipCandidates.add(student);
            }
        }

        // Вывод информации кандидатов на специальную стипендию
        System.out.println("\nКандидаты на специальную стипендию:");
        for (Yuchashchiy candidate : scholarshipCandidates) {
            System.out.println(candidate.getName());
        }
    }
}