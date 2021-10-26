import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class DictionaryApp {
    public static void main(String[] main) {
        try {
            FileReader inputFileReader = new FileReader("./src/data.txt");
            Scanner inputFile = new Scanner(inputFileReader);
            CreateDictionary dictionary = new CreateDictionary();
            dictionary.WriteDictionaryToFile(inputFile);
            dictionary.WriteWordCount(inputFile);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
