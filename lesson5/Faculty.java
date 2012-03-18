package lesson5;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 18.03.12
 * Time: 18:58
 */

public class Faculty implements University {

    private String name;
    private String degree;
    
    public Faculty(String degree, String name){
        this.degree = degree;
        this.name = name;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "FACULTY: " + name + ", " + degree + " degree";
    }
}
