package lab5;

class Student extends Yuchashchiy {
    private int[] semesterGrades; // Оценки за сессию
    private int[] courseworkGrades; // Оценки за курсовые работы

    public Student(String name, String gender, int age, int[] semesterGrades, int[] courseworkGrades) {
        super(name, gender, age);
        this.semesterGrades = semesterGrades;
        this.courseworkGrades = courseworkGrades;
    }

    public boolean hasSpecialScholarship() {
        double averageGrade = calculateAverage(semesterGrades);
        boolean has5ForCoursework = true;

        for (int grade : courseworkGrades) {
            if (grade != 5) {
                has5ForCoursework = false;
                break;
            }
        }

        return averageGrade >= 4.75 && has5ForCoursework;
    }

    private double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public void printInfo() {
        System.out.println("Студент: " + getName() + ", Пол: " + getGender() + ", Возраст: " + getAge());
    }
}