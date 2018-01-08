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
