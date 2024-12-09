package lab6;

class Shkolnik extends Yuchashchiy {
    private int[] grades; // Годовые оценки
    private int schoolNumber; // Номер школы

    public Shkolnik(String name, String surname, int age, int[] grades, int schoolNumber) {
        super(name, surname, age);
        setGrades(grades);
        setSchoolNumber(schoolNumber);
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        for (int grade : grades) {
            if (grade < 2 || grade > 5) {
                throw new IllegalArgumentException("Оценки должны быть в диапазоне от 2 до 5");
            }
        }
        this.grades = grades;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    @Override
    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }
}