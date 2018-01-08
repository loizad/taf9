import java.util.ArrayList;
import java.util.List;

public class Corrector {

  private final String text;
  private List<String> wrongWords;
  private Dictionary dictionary;

  public Corrector(String text, Dictionary dictionary) {  
    this.text = text;
    this.dictionary = dictionary;
  }

  public void correctText() {

    wrongWords = new ArrayList<>();
    String[] originalWords = this.getWordsFromText(text);

    for (String word : originalWords) {
	  System.out.println(word);
      if (!dictionary.existsInDictionary(word))
        wrongWords.add(word);
    }
  }