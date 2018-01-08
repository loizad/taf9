import java.util.ArrayList;
import java.util.List;

public class Corrector {

  private final String text;
  private List<String> wrongWords;
  private Dictionary dictionary;
  //Creation of the constructor 
  public Corrector(String text, Dictionary dictionary) {  
    this.text = text;
    this.dictionary = dictionary;
  }
  //Creating originalWords array to store words from the text given then checks if these words exist in dictionary if not adds it in wrongwordsList
  public void correctText() {

    wrongWords = new ArrayList<>();
    String[] originalWords = this.getWordsFromText(text);

    for (String word : originalWords) {
	  System.out.println(word);
      if (!dictionary.existsInDictionary(word))
        wrongWords.add(word);
    }
  }
