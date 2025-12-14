import java.io.*;

public class UppercaseToLowercaseFile {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {

            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(Character.toLowerCase((char) ch));
            }

            System.out.println("File converted to lowercase successfully.");

        } catch (IOException e) {
            System.out.println("Error while processing file.");
        }
    }
}
