import java.io.*;

public class UserInputToFile {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("user_details.txt")) {

            System.out.print("Enter Name: ");
            String name = br.readLine();

            System.out.print("Enter Age: ");
            String age = br.readLine();

            System.out.print("Enter Favorite Programming Language: ");
            String language = br.readLine();

            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + language + "\n");

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error occurred while reading or writing data.");
        }
    }
}
