import java.io.*;

public class ImageByteArrayCopy {

    public static void main(String[] args) {

        File inputImage = new File("input.jpg");
        File outputImage = new File("output.jpg");

        try (FileInputStream fis = new FileInputStream(inputImage);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            int data;
            while ((data = fis.read()) != -1) {
                baos.write(data);
            }

            byte[] imageBytes = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(outputImage)) {

                while ((data = bais.read()) != -1) {
                    fos.write(data);
                }
            }

            System.out.println("Image copied successfully.");

        } catch (IOException e) {
            System.out.println("Error processing image file.");
        }
    }
}
