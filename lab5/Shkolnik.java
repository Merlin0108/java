package lab5;

class Shkolnik extends Uchashchysya {
    private int[] grades; // Годовые оценки
    private boolean[] olympiadWins; // Участие в олимпиадах: 0 - школьная, 1 - городская, 2 - областная

    public Shkolnik(String name, String gender, int age, int[] grades, boolean[] olympiadWins) {
        super(name, gender, age);
        this.grades = grades;
        this.olympiadWins = olympiadWins;
    }

    @Override
    public boolean isEligibleForScholarship() {
        int countFives = 0;
        boolean hasOlympiad = olympiadWins[2]; // Участие в областной олимпиаде

        for (int grade : grades) {
            if (grade == 5) {
                countFives++;
            } else if (grade < 4) {
                return false; // Если есть хотя бы одна тройка
            }
        }

        return countFives >= 4 && hasOlympiad; // Проверка условий для стипендии
    }

    public boolean hasFirstPlaceInOlympiad() {
        return olympiadWins[0]; // Если первое место в школьной олимпиаде
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.print("Годовые оценки: ");
        for (int grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }
}