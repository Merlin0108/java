package lab7;
import java.util.*;

class ClassJournal {
    private int grade;
    private List<Student> students;

    public ClassJournal(int grade) {
        this.grade = grade;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int getGrade() {
        return grade;
    }

    public List<Student> getStudents() {
        return students;
    }

    public double getAverageMark() {
        if (students.isEmpty()) return 0;
        double total = 0;
        for (Student student : students) {
            total += student.getMark();
        }
        return total / students.size();
    }
}