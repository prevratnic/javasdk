package lesson1.emp;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 03.11.11
 * Time: 22:21
 */


public class Employee {

    private int id;
    private String name;
    private String position;
    private double salary;
    
    private static int count = 1;

    public Employee( String name ){
        this(name, "worker", 5000);
    }

    public Employee( String name, String position ){
        this( name, position, position.equals("worker")  ? 5000 : 6000 );
    }

    public Employee( String name, String position, double salary ){

        this.id = Employee.count++;
        this.name = name;
        this.position = position;

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
        return  " emp { "+ "\t"+
                " id=" + id + "\t"+
                " name='" + name + '\''+",\t"+
                " position='" + position + '\''+",\t"+
                " salary=" + salary +
                " }" + "\n";
    }

}
