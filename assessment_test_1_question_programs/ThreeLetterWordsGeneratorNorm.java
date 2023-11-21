
// java program 8.a ii)
import java.util.Arrays;
import java.util.Scanner;

public class ThreeLetterWordsGeneratorNorm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get a five-letter word from the user
        System.out.print("Enter a five-letter word: ");
        String inputWord = scanner.nextLine();

        if (inputWord.length() == 5) {
            // Generate and print all possible three-letter words
            System.out.println("All possible three-letter words:");
            generateThreeLetterWords(inputWord.toLowerCase());
        } else {
            System.out.println("Please enter a five-letter word.");
        }

        scanner.close();
    }

    private static void generateThreeLetterWords(String word) {
        char[] letters = word.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                for (int k = 0; k < letters.length; k++) {
                    if (i != j && j != k && i != k) {
                        char[] threeLetterWord = { letters[i], letters[j], letters[k] };
                        Arrays.sort(threeLetterWord);
                        System.out.println(new String(threeLetterWord));
                    }
                }
            }
        }
    }
}