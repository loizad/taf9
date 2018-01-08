import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class OrthoCorrect {

  private Dictionary dictionary;
  private Corrector corrector;
  private Scanner consoleReader;
  //This method reads the text from the console creates a Dictionary object and then checks if it is loadedSuccessfully if not throws exception 
  private void initializeApplication(String dictionaryFilePath) throws Exception {
    consoleReader = new Scanner(System.in, "windows-1253"); 
    dictionary = new Dictionary();
    boolean dictionaryWasLoadedSuccessfully = dictionary.loadDictionary(dictionaryFilePath); 
    if (!dictionaryWasLoadedSuccessfully) 
      throw new Exception("Αποτυχία φόρτωσης λεξικού.Η εφαρμογή θα σταματήσει");
}
