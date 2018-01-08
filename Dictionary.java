import java.io.*;
import java.util.*;
public class Dictionary {

  
  private List<String> dictionaryList;
  private ArrayList<String> arrayDictionaryList;
  private File dictionary;

  //Creating the constructor 
  public Dictionary() {
      this.dictionaryList = new ArrayList<>();
  }
  
  //Check if dictionary exists and if ti is loaded return true or else false //
  public boolean loadDictionary(String dictionaryFilePath) {
      dictionary = new File(dictionaryFilePath); 
      if (!dictionary.exists()) {
        System.out.println("Το μονοπάτι που δώθηκε για το αρχείο του λεξικού δεν είναι έγκυρο");
        return false; 
      }
      try {
        dictionaryToList();
      } catch (IOException e) {
        return false;
      }
      return true;
  }
  
  public boolean existsInDictionary(final String text) {


    return dictionaryList.stream().anyMatch(word -> text.equalsIgnoreCase(word));

    //Για καθε στοιχειο του dictionaryList το βαζει στην παραμετρο word και εφαρμοζει πανω του την μεθοδο equalsIgnoreCase η οποια συγκρινει η λεξη που υπαρχει στο τεξτ αμα ειναι ιδια με την word απο το dictionary list και αν ειναι επιστρεφει true η false//


  }
  

  //This method opens the dictionary file and then read it then adds each row to the List accordingly//
  
   private void dictionaryToList() throws IOException {
      FileReader fileReader = null;
      BufferedReader reader = null;
      try {
        fileReader = new FileReader(dictionary);
        reader = new BufferedReader(fileReader);
        String word = null;
        while ((word = reader.readLine()) != null) {
          dictionaryList.add(word); // each word is APPENDED to the list. We assume the words come IN ORDER
        }
      } catch (FileNotFoundException e) {
        System.out.println("Μη αναμενόμενη συμπεριφορά! Το αρχείο του λεξικού έχει διαγραφεί από εξωτερικό παράγοντα.");
        throw e;
      } catch (IOException e) {
        System.out.println("Μη αναμενόμενη συμπεριφορά! Εμφανίστηκε πρόβλημα κατά το διάβασμα του λεξικού. Παρακαλώ ελέγξτε την ορθότητά του.");
        throw e;
      } finally {
        try {
          if (reader != null) {
            reader.close();
          }
        } catch (IOException e) {

        }
      }
    }
  }
