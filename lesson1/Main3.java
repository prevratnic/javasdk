package lesson1;

import lesson1.emp.Employee;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 03.11.11
 * Time: 23:12
 */

public class Main3 {

    public static void main( String[] args ){

        Employee[] employee = new Employee[10];

        employee[0] = new Employee("Sveta");
        employee[1] = new Employee("Tanya", "worker");
        employee[2] = new Employee("Nina", "Prodovech", 100);
        employee[3] = new Employee("Sveta");
        employee[4] = new Employee("Tanya", "Manager");
        employee[5] = new Employee("Nina", "Prodovech", 200);
        employee[6] = new Employee("Sveta");
        employee[7] = new Employee("Olecya", "not_worker");
        employee[8] = new Employee("Nina", "Prodovech", 300);
        employee[9] = new Employee("Sveta");

        for( int i = 0; i < employee.length; i++ ){
            System.out.print( employee[i] );
        }

        sumSalary( employee );

    }

   public static void sumSalary( Employee[] emp ){

       double sum = 0;
       double sal = 0;
       String pos = null;

        for( int i = 0; i < emp.length; i++ ){

            sum += emp[i].getSalary();

            if( sal < emp[i].getSalary() ){
                sal = emp[i].getSalary();
                pos = emp[i].getPosition();
            }
        }

       System.out.print("Сумма по зарплате: " + sum + " " + pos + " " + sal );

   }

}
