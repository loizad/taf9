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
        System.out.println("Ôï ìïíïðÜôé ðïõ äþèçêå ãéá ôï áñ÷åßï ôïõ ëåîéêïý äåí åßíáé Ýããõñï.");
        return false; 
      }
      try {
        dictionaryToList();
      } catch (IOException e) {
        return false;
      }
      return true;
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
