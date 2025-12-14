import java.io.*;

public class StudentDataStream {

    public static void main(String[] args) {

        String fileName = "student.dat";

        // Writing data
        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(fileName))) {

            dos.writeInt(101);
            dos.writeUTF("Rahul");
            dos.writeDouble(8.5);

            System.out.println("Student data saved.");

        } catch (IOException e) {
            System.out.println("Error writing data.");
        }

        // Reading data
        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(fileName))) {

            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("Roll: " + roll);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } catch (IOException e) {
            System.out.println("Error reading data.");
        }
    }
}
