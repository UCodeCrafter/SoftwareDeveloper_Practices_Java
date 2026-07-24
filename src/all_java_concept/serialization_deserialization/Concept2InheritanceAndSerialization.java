package all_java_concept.serialization_deserialization;


//What happen when a child clas implements serializable, but parent does NOT

import org.w3c.dom.ls.LSOutput;

import java.io.*;

/**
 * The Golden Rule of Non-Serializable Parents
 * ⚠️ The Rule: If a child class is Serializable but its parent class is NOT:
 * The parent class MUST have an accessible no-arg constructor (public or protected).
 * During deserialization, Java will execute the parent's no-arg constructor to initialize the parent's fields, while the child's fields are restored directly from the serialized byte stream (without running the child's constructor).
 * If the non-serializable parent does not have a default no-arg constructor, deserialization will fail at runtime with an InvalidClassException.
 */
public class Concept2InheritanceAndSerialization {
    public static void main(String[] args) throws Exception {
        System.out.println("----- Creating Employee Object -----");
        Employee employee = new Employee(101, "Uttam");
        System.out.println("Employee Object Created: " + employee);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
            oos.writeObject(employee);
            System.out.println("Employee Object Serialized.");
        }

        System.out.println("--- 2. Deserializing object ----");
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))){
            Employee restored = (Employee) ois.readObject();
            System.out.println("Restored employee: "+ restored);
        }

    }

}

class Parent {
    String name;
    public Parent(){
        System.out.println("--> person (Parent) no-arg constructor called.");
        this.name = "Default Name";
    }
    public Parent(String name){
        this.name = name;
    }
}

class Employee extends Parent implements Serializable {
    private static final long serialVersionUID = 1L;

    int employeeId;

    public Employee(int employeeId, String name){
        super(name);
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name;
    }
}


