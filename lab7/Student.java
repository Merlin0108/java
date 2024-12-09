package lab7;

class Student {
    private String surname;
    private String name;
    private int grade; // Номер класса
    private String subject;
    private int mark;

    public Student(String surname, String name, int grade, String subject, int mark) {
        this.surname = surname;
        this.name = name;
        this.grade = grade;
        this.subject = subject;
        setMark(mark);
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public String getSubject() {
        return subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if (mark < 2 || mark > 5) {
            throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5");
        }
        this.mark = mark;
    }
}