import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class OrthoCorrect {

  private Dictionary dictionary;
  private Corrector corrector;
  private Scanner consoleReader;

  private void initializeApplication(String dictionaryFilePath) throws Exception {
    consoleReader = new Scanner(System.in, "windows-1253"); // talk about how reading from the console works
    dictionary = new Dictionary();
    boolean dictionaryWasLoadedSuccessfully = dictionary.loadDictionary(dictionaryFilePath); // talk about variable names
    if (!dictionaryWasLoadedSuccessfully) // talk about throwing exceptions for control flow and why it is usually bad
      throw new Exception("Αποτυχία φόρτωσης λεξικού. Η εφαρμογή θα σταματήσει.");
}