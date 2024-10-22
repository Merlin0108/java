package lab5;
import java.util.ArrayList;

public class Uchashchysya {
    protected String name;
    protected String gender;
    protected int age;

    public Uchashchysya(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void printInfo() {
        System.out.println("Имя: " + name + ", Пол: " + gender + ", Возраст: " + age);
    }

    public boolean isEligibleForScholarship() {
        return false; // Базовый метод, переопределяется в наследниках
    }
}
