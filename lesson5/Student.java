package lesson5;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 18.03.12
 * Time: 19:15
 */

public class Student implements University {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "STUDENT: " + name + ", " + age + " years";
    }

}
