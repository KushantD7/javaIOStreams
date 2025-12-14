import java.io.*;
import java.util.*;

public class WordCountTopFive {

    public static void main(String[] args) {

        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            List<Map.Entry<String, Integer>> list =
                    new ArrayList<>(wordCount.entrySet());

            list.sort((a, b) -> b.getValue() - a.getValue());

            System.out.println("Top 5 Most Frequent Words:");
            for (int i = 0; i < Math.min(5, list.size()); i++) {
                System.out.println(list.get(i).getKey() + " = " + list.get(i).getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
