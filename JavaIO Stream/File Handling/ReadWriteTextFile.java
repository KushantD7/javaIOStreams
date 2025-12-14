import java.io.*;

public class ReadWriteTextFile {

    public static void main(String[] args) {

        File sourceFile = new File("input.txt");
        File destinationFile = new File("output.txt");

        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int ch;
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("I/O Error occurred.");
        }
    }
}
