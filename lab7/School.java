package lab7;
import java.io.*;
import java.util.*;

public class School {
    private Map<Integer, ClassJournal> journals;

    public School() {
        journals = new HashMap<>();
    }

    public void loadStudentsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                String surname = data[0];
                String name = data[1];
                int grade = Integer.parseInt(data[2]);
                String subject = data[3];
                int mark = Integer.parseInt(data[4]);

                Student student = new Student(surname, name, grade, subject, mark);
                journals.computeIfAbsent(grade, k -> new ClassJournal(grade)).addStudent(student);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка в формате данных: " + e.getMessage());
        }
    }

    public void printStudentsByGrade(int grade, int mark) {
        ClassJournal journal = journals.get(grade);
        if (journal != null) {
            System.out.printf("Учащиеся в классе %d с оценкой %d:\n", grade, mark);
            for (Student student : journal.getStudents()) {
                if (student.getMark() == mark) {
                    System.out.printf("%s %s\n", student.getSurname(), student.getName());
                }
            }
        } else {
            System.out.printf("Класс %d не найден.\n", grade);
        }
    }

    public void sortAndPrintAverageMarks() {
        List<ClassJournal> sortedJournals = new ArrayList<>(journals.values());
        sortedJournals.sort(Comparator.comparingDouble(ClassJournal::getAverageMark));

        System.out.println("Классы отсортированы по средней успеваемости:");
        for (ClassJournal journal : sortedJournals) {
            System.out.printf("Класс %d: Средняя оценка %.2f\n", journal.getGrade(), journal.getAverageMark());
        }
    }

    public void printStudentsBySubject(String subject) {
        List<Student> allStudents = new ArrayList<>();
        for (ClassJournal journal : journals.values()) {
            for (Student student : journal.getStudents()) {
                if (student.getSubject().equalsIgnoreCase(subject)) {
                    allStudents.add(student);
                }
            }
        }

        allStudents.sort(Comparator.comparing(Student::getSurname));

        System.out.printf("Учащиеся по предмету %s, отсортированные по фамилии:\n", subject);
        for (Student student : allStudents) {
            System.out.printf("%s %s\n", student.getSurname(), student.getName());
        }
    }

    public void saveClassReports(String subject) {
        for (ClassJournal journal : journals.values()) {
            String filename = String.format("class_report_grade_%d.txt", journal.getGrade());
            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                writer.printf("Отчет для класса %d по предмету %s:\n", journal.getGrade(), subject);
                for (Student student : journal.getStudents()) {
                    if (student.getSubject().equalsIgnoreCase(subject)) {
                        writer.printf("%s %s - Оценка: %d\n", student.getSurname(), student.getName(), student.getMark());
                    }
                }
                System.out.printf("Отчет класса %d сохранен в файл %s\n", journal.getGrade(), filename);
            } catch (IOException e) {
                System.err.println("Ошибка при записи файла: " + e.getMessage());
            }
        }
    }

    public void findClassByStudent(String surname, String name) {
        for (ClassJournal journal : journals.values()) {
            for (Student student : journal.getStudents()) {
                if (student.getSurname().equalsIgnoreCase(surname) && student.getName().equalsIgnoreCase(name)) {
                    System.out.printf("Студент %s %s учится в классе %d\n", surname, name, journal.getGrade());
                    return;
                }
            }
        }
        System.out.printf("Студент %s %s не найден в школе\n", surname, name);
    }

    public void findSubjectWithHighestAverageMark() {
        Map<String, List<Integer>> subjectMarks = new HashMap<>();

        for (ClassJournal journal : journals.values()) {
            for (Student student : journal.getStudents()) {
                subjectMarks.computeIfAbsent(student.getSubject(), k -> new ArrayList<>()).add(student.getMark());
            }
        }

        String bestSubject = null;
        double highestAverage = 0;

        for (Map.Entry<String, List<Integer>> entry : subjectMarks.entrySet()) {
            double average = entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0);
            if (average > highestAverage) {
                highestAverage = average;
                bestSubject = entry.getKey();
            }
        }

        if (bestSubject != null) {
            System.out.printf("Предмет с самой высокой средней успеваемостью: %s (%.2f)\n", bestSubject, highestAverage);
        } else {
            System.out.println("Не удалось определить предмет с самой высокой успеваемостью.");
        }
    }

    public static void main(String[] args) {
        School school = new School();
        school.loadStudentsFromFile("C:/Users/micha/IdeaProjects/untitled1/java/lab7/data_school.txt");

        // Пример использования функций
        school.printStudentsByGrade(10, 5);
        school.sortAndPrintAverageMarks();
        school.printStudentsBySubject("физика");
        school.saveClassReports("физика");
        school.findClassByStudent("Иванов", "Иван");
        school.findSubjectWithHighestAverageMark();
    }
}