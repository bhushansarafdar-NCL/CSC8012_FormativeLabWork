import java.io.PrintWriter;
import java.util.*;

public class CreateDictionary {

    public CreateDictionary() {

    }

    public void WriteDictionaryToFile(Scanner inputFile) {
        try {
            String fileText = "";
            ArrayList<String> words  = new ArrayList<>();
            while (inputFile.hasNext()) {
                String[] allWords = ReadWordsFromFile(inputFile);
                for (int i = 0; i < allWords.length; i++) {
                    if (!words.contains(allWords[i]) && !allWords[i].matches("[0-9]+")) {
                        words.add(allWords[i].replace('.',' ').replace(',', ' ').trim().toLowerCase());
                    }
                }
            }

            PrintWriter printFile = new PrintWriter("./src/results.txt");
            Collections.sort(words);
            for (String word:
                    words) {
                printFile.println(word);
            }
            printFile.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void WriteWordCount(Scanner inputFile) {
        try {
            String fileText = "";
            ArrayList<String> words  = new ArrayList<>();
            Dictionary<String, Integer> wordCounts = new Hashtable<>();
            while (inputFile.hasNext()) {
                String[] allWords = ReadWordsFromFile(inputFile);

                for (int i = 0; i < allWords.length; i++) {
                    String word = allWords[i].replace('.',' ').replace(',',' ').trim().toLowerCase();
                    if (!word.matches("[0-9]+") && wordCounts.get(word) == null) {
                        wordCounts.put(word, 1);
                        words.add(word);
                    }
                    else if (!word.matches("[0-9]+") && wordCounts.get(word) != null){
                        wordCounts.put(word, wordCounts.get(word) + 1);
                    }
                }
            }

            PrintWriter printFile = new PrintWriter("./src/results2.txt");
            for (String word:
                    words) {
                printFile.println(String.format("%-20s",word) + wordCounts.get(word));
            }
            printFile.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private  String[] ReadWordsFromFile(Scanner inputFile) {
        String fileText = inputFile.nextLine();
        return  fileText.split(" ");
    }
}
