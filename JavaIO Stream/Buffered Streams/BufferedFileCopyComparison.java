import java.io.*;

public class BufferedFileCopyComparison {

    public static void main(String[] args) {

        File source = new File("largefile.dat");
        File unbufferedDest = new File("copy_unbuffered.dat");
        File bufferedDest = new File("copy_buffered.dat");

        int bufferSize = 4096;

        // Unbuffered copy
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(unbufferedDest)) {

            byte[] buffer = new byte[bufferSize];
            int bytesRead;

            long start = System.nanoTime();

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            System.out.println("Unbuffered Time: " + (end - start) + " ns");

        } catch (IOException e) {
            System.out.println("Error in unbuffered copy.");
        }

        // Buffered copy
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(bufferedDest))) {

            byte[] buffer = new byte[bufferSize];
            int bytesRead;

            long start = System.nanoTime();

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            long end = System.nanoTime();
            System.out.println("Buffered Time: " + (end - start) + " ns");

        } catch (IOException e) {
            System.out.println("Error in buffered copy.");
        }
    }
}
