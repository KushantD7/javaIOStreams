import java.io.*;
import java.util.*;

// Employee class
class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class EmployeeSerializationDemo {

    public static void main(String[] args) {

        String fileName = "employees.dat";

        // Create employee list
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "IT", 50000));
        employees.add(new Employee(2, "Bob", "HR", 45000));
        employees.add(new Employee(3, "Charlie", "Finance", 60000));

        // Serialization
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(employees);
            System.out.println("Employees saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while saving employees.");
        }

        // Deserialization
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            List<Employee> empList = (List<Employee>) ois.readObject();

            System.out.println("Retrieved Employees:");
            for (Employee e : empList) {
                System.out.println(e.id + " " + e.name + " " +
                                   e.department + " " + e.salary);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while retrieving employees.");
        }
    }
}
