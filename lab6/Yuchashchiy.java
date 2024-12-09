package lab6;

abstract class Yuchashchiy implements Comparable<Yuchashchiy>, ComparableYuchashchiy {
    private String name;
    private String surname;
    private int age;

    public Yuchashchiy(String name, String surname, int age) {
        setName(name);
        setSurname(surname);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || !Character.isUpperCase(name.charAt(0))) {
            throw new IllegalArgumentException("Имя должно начинаться с большой буквы");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || !Character.isUpperCase(surname.charAt(0))) {
            throw new IllegalArgumentException("Фамилия должна начинаться с большой буквы");
        }
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Возраст должен быть от 0 до 150");
        }
        this.age = age;
    }

    @Override
    public int compareTo(Yuchashchiy other) {
        return this.surname.compareToIgnoreCase(other.surname);
    }
}