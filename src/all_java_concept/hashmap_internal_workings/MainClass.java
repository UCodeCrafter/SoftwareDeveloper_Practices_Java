package all_java_concept.hashmap_internal_workings;


import java.util.HashMap;
import java.util.Objects;

class Employee {
    int id;
    String name;
    long salary;
    public Employee(int id, String name, long salary){
        this.id  = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public boolean equals(Object o){
        if( o == null) return false;
        if(o==null || getClass() != o.getClass()) return false;
        Employee  employee = (Employee) o;
        return id == employee.id && salary == employee.salary && Objects.equals(name, employee.name);
    }
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }
}
public class MainClass {
    public static void main(String[] args){
        System.out.println("HashMap Internal Working::");

        HashMap<Employee, String>  hashMap = new HashMap<>();
        hashMap.put(new Employee(1, "Uttam1", 2000), "CSE_1");
        hashMap.put(new Employee(2, "Uttam2", 2000), "CSE_2");
        hashMap.put(new Employee(3, "Uttam3", 2000), "CSE_3");
        hashMap.put(new Employee(4, "Uttam4", 2000), "CSE_4");
        hashMap.put(new Employee(5, "Uttam5", 2000), "CSE_5");
        hashMap.put(new Employee(6, "Uttam6", 2000), "CSE_6");
        hashMap.put(new Employee(7, "Uttam7", 2000), "CSE_7");
        hashMap.put(new Employee(8, "Uttam8", 2000), "CSE_8");
        hashMap.put(new Employee(8, "Uttam8", 2000), "CSE_9");
        hashMap.put(new Employee(8, "Uttam8", 2000), "CSE_10");

        System.out.println( "Value is: "+ hashMap.get(new Employee(8, "Uttam8", 2000)));


    }
}
