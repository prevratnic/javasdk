package lesson1.emp;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 03.11.11
 * Time: 22:21
 */


public class Employee {

    private static int id;
    private String name;
    private String position;
    private double salary;


    public Employee( String name ){
        this(name, "worker", 5000);
    }

    public Employee( String name, String position ){
        this.id++;
        this.name = name;
        this.position = position;
        this.salary = 6000;

        if( position.equals("worker") ){
            this.salary = 5000;
        }

    }

    public Employee( String name, String position, double salary ){
        this.id++;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "emp { " +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                " }" + "\n";
    }

}
