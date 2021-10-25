import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateDictionary {

    public CreateDictionary() {

    }

    public void WriteDictionaryToFile(Scanner inputFile) {
        try {
            String fileText = "";
            ArrayList<String> words  = new ArrayList<>();
            while (inputFile.hasNext()) {
                fileText = inputFile.nextLine();
                String[] allWords = fileText.split(" ");
                for (int i = 0; i < allWords.length; i++) {
                    if (!words.contains(allWords[i]) && !allWords[i].matches("[0-9]+")) {
                        words.add(allWords[i].replace('.',' ').replace(',', ' ').trim().toLowerCase());
                    }
                }
            }

            PrintWriter printFile = new PrintWriter("./src/results.txt");
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
}
