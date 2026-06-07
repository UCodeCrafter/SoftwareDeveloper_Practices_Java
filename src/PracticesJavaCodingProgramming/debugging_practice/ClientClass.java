package PracticesJavaCodingProgramming.debugging_practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Employee{
    long id;
    String name;
    long salary;
    String department;

    public Employee(long id, String name, long salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

public class ClientClass {
    public static void main(String[] args) {

        List<Employee> employes = new ArrayList<>();
        employes.addAll(Arrays.asList(new Employee(1, "Uttam ", 50000, "IT"),
                new Employee(2, "Rakesh", 60000, "MECH"),
                new Employee(3, "Ravi", 67833, "CSE"),
                new Employee(4, "Kamlesh", 6767, "EE"),
                new Employee(5, "Srikant", 56565, "ECE"),
                new Employee(6, "Puja", 564546, "CIVIL"),
                new Employee(7, "Rohit", 4465, "AIML"),
                new Employee(8, "Rinki", 25214, "CE"),
                new Employee(9, "Chotu", 34345, "CSE"),
                new Employee(10, "Karan", 388290, "IT"),
                new Employee(11, "Rupali", 3092784, "EE"),
                new Employee(12, "Lakshi", 37872, "ECE"),
                new Employee(13, "Sheetal", 559082, "MECH"),
                new Employee(14, "Prema", 3490, "CSE"),
                new Employee(15, "Krishna", 90, "MECH")
        ));

        for(Employee emp : employes){
            if(emp.getName().equalsIgnoreCase("Prema")){
                System.out.println("Employee Details is: " + emp);
            }
        }

    }
}
