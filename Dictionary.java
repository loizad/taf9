import java.io.*;
import java.util.*;
public class Dictionary {

  //Οι μεταβλητές στιγμιοτύπου που θα χρειαστούμε για την κλάση μας
  private List<String> dictionaryList;
  private ArrayList<String> arrayDictionaryList;
  private File dictionary;

  //Δημιουργία του κονστρακτορά μας
  public Dictionary() {
      this.dictionaryList = new ArrayList<>();
  }
  //Ελένγχουμε αμα υπάρχει το λεξικό και αν φορτωθεί σωστά επιστρέφουμε true αλλιώς false//
  public boolean loadDictionary(String dictionaryFilePath) {
      dictionary = new File(dictionaryFilePath); // talk about File pointers and how they work
      if (!dictionary.exists()) {
        System.out.println("Το μονοπάτι που δώθηκε για το αρχείο του λεξικού δεν είναι έγγυρο.");
        return false; // talk about returning early
      }
      try {
        dictionaryToList();
      } catch (IOException e) {
        return false;
      }
      return true;
  }