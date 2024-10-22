package lab5;

class Student extends Uchashchysya {
    private double[] sessionGrades; // Оценки за сессии
    protected double[] courseWorkGrades; // Оценки за курсовые работы

    public Student(String name, String gender, int age, double[] sessionGrades, double[] courseWorkGrades) {
        super(name, gender, age);
        this.sessionGrades = sessionGrades;
        this.courseWorkGrades = courseWorkGrades;
    }

    @Override
    public boolean isEligibleForScholarship() {
        double averageSessionGrade = calculateAverage(sessionGrades);
        double averageCourseWorkGrade = calculateAverage(courseWorkGrades);

        return averageSessionGrade >= 4.75 && averageCourseWorkGrade == 5;
    }

    private double calculateAverage(double[] grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.print("Оценки за сессии: ");
        for (double grade : sessionGrades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }
}