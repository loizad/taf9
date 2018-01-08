import java.io.*;
import java.util.*;
public class Dictionary {

  //�� ���������� ������������ ��� �� ����������� ��� ��� ����� ���
  private List<String> dictionaryList;
  private ArrayList<String> arrayDictionaryList;
  private File dictionary;

  //���������� ��� ������������ ���
  public Dictionary() {
      this.dictionaryList = new ArrayList<>();
  }
  //���������� ��� ������� �� ������ ��� �� �������� ����� ������������ true ������ false//
  public boolean loadDictionary(String dictionaryFilePath) {
      dictionary = new File(dictionaryFilePath); // talk about File pointers and how they work
      if (!dictionary.exists()) {
        System.out.println("�� �������� ��� ������ ��� �� ������ ��� ������� ��� ����� ������.");
        return false; // talk about returning early
      }
      try {
        dictionaryToList();
      } catch (IOException e) {
        return false;
      }
      return true;
  }