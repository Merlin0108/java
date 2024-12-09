package lab5;

class Shkolnik extends Yuchashchiy {
    private int[] grades; // Годовые оценки
    private boolean hasOlympiadPrize; // Участие в олимпиадах

    public Shkolnik(String name, String gender, int age, int[] grades, boolean hasOlympiadPrize) {
        super(name, gender, age);
        this.grades = grades;
        this.hasOlympiadPrize = hasOlympiadPrize;
    }

    public boolean hasSpecialScholarship() {
        boolean has5inSubjects = grades[0] == 5 && grades[1] == 5 && grades[2] == 5 && grades[3] == 5;
        boolean hasOtherGrades = true;
        for (int grade : grades) {
            if (grade < 4) {
                hasOtherGrades = false;
                break;
            }
        }
        return has5inSubjects && hasOtherGrades && (hasOlympiadPrize);
    }

    public boolean isGirlWithOlympiadPrize() {
        return "female".equalsIgnoreCase(getGender()) && hasOlympiadPrize;
    }

    public void printInfo() {
        System.out.println("Школьник: " + getName() + ", Пол: " + getGender() + ", Возраст: " + getAge());
    }
}