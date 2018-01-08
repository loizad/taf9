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
  
  //This method actually executes the application creating a Corrector object that takes 2 parameters the text to check and the dictionary
  //it runs correctText and pringWrongWords
  private void start() throws IOException {
     String inputText;
     boolean tryAgain;

      do {
       System.out.println("Πρόγραμμα διόρθωσης ορθογραφίας");
       System.out.println("Παρακαλώ εισάγετε μία φράση και πατήστε ENTER");

       inputText = consoleReader.nextLine();
       System.out.println(inputText);




       corrector = new Corrector(inputText, dictionary);
       corrector.correctText();
       corrector.printWrongWords();


       System.out.println("Θέλετε να δώσετε καινούριο κείμενο; Y/n");
       inputText = consoleReader.nextLine();

          if ("y".equalsIgnoreCase(inputText)) {
	           tryAgain = true;
	         } else {
	           tryAgain = false;
	         }
	       } while (tryAgain);
	       System.out.println("Ευχαριστούμε που μας επιλέξατε.");
	     }
      //running our application//
	     public static void main(String[] args) throws Exception {
	       OrthoCorrect application = new OrthoCorrect();
	       application.initializeApplication(args[0]);
	       application.start();
	     }

}
  
  


  
  
  
  
  
  
  
