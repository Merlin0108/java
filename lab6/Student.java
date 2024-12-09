package lab6;

class Student extends Yuchashchiy {
    private int[] semesterGrades; // Оценки за сессию
    private int[] courseworkGrades; // Оценки за курсовые работы

    public Student(String name, String surname, int age, int[] semesterGrades, int[] courseworkGrades) {
        super(name, surname, age);
        setSemesterGrades(semesterGrades);
        setCourseworkGrades(courseworkGrades);
    }

    public int[] getSemesterGrades() {
        return semesterGrades;
    }

    public void setSemesterGrades(int[] semesterGrades) {
        for (int grade : semesterGrades) {
            if (grade < 2 || grade > 5) {
                throw new IllegalArgumentException("Оценки должны быть в диапазоне от 2 до 5");
            }
        }
        this.semesterGrades = semesterGrades;
    }

    public int[] getCourseworkGrades() {
        return courseworkGrades;
    }

    public void setCourseworkGrades(int[] courseworkGrades) {
        for (int grade : courseworkGrades) {
            if (grade < 2 || grade > 5) {
                throw new IllegalArgumentException("Оценки должны быть в диапазоне от 2 до 5");
            }
        }
        this.courseworkGrades = courseworkGrades;
    }

    @Override
    public double getAverageGrade() {
        double totalGrades = 0;
        for (int grade : semesterGrades) {
            totalGrades += grade;
        }
        double totalCoursework = 0;
        for (int grade : courseworkGrades) {
            totalCoursework += grade;
        }
        return (totalGrades + totalCoursework) / (semesterGrades.length + courseworkGrades.length);
    }
}