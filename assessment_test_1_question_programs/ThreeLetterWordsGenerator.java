import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class ThreeLetterWordsGenerator {

    public static void main(String[] args) {
        try {
            // Load a dictionary of English words
            Set<String> dictionary = loadDictionary("words.txt");

            // Example: Get a five-letter word from the user
            String inputWord = "bathe"; // Replace with user input

            if (inputWord.length() == 5) {
                // Generate and print meaningful three-letter words
                System.out.println("Meaningful three-letter words:");
                generateMeaningfulThreeLetterWords(inputWord.toLowerCase(), dictionary);
            } else {
                System.out.println("Please enter a five-letter word.");
            }

        } catch (IOException e) {
            System.out.println("Error loading the dictionary.");
        }
    }

    private static void generateMeaningfulThreeLetterWords(String word, Set<String> dictionary) {
        char[] letters = word.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                for (int k = 0; k < letters.length; k++) {
                    if (i != j && j != k && i != k) {
                        char[] threeLetterWord = { letters[i], letters[j], letters[k] };
                        Arrays.sort(threeLetterWord);
                        String candidateWord = new String(threeLetterWord);

                        if (dictionary.contains(candidateWord)) {
                            System.out.println(candidateWord);
                        }
                    }
                }
            }
        }
    }

    private static Set<String> loadDictionary(String filePath) throws IOException {
        Set<String> dictionary = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            dictionary.add(line.trim().toLowerCase());
        }

        reader.close();
        return dictionary;
    }
}
