/**
 * Created by Deepankit on 11/11/2016.
 */
public class TextJustification {

  public static final String DELIMITER = " ";

  public static void main(String[] args) {
    TextJustification textJustification = new TextJustification();
    int blockSize = 16;
    String input = "This is an example of text justification.";
    String[] justifiedText = textJustification.justifyText(input, blockSize);
    textJustification.display(justifiedText);
  }

  private void display(String[] justifiedText) {
    for (String str : justifiedText)
      System.out.println(str);
  }

  private String[] justifyText(String input, int blockSize) {

    int blockCount = input.length() / blockSize;
    blockCount = input.length() % blockSize == 0 ? blockCount : blockCount + 1;
    String[] words = input.split(DELIMITER);
    StringBuilder formattedWord = new StringBuilder();
    int index = 0;

    String[] formattedStrings = new String[blockCount];

    for (int formattedStringIndex = 0; formattedStringIndex < blockCount; formattedStringIndex++) {
      while (index < words.length && (blockSize - (formattedWord.length() + words[index].length()) > 0)) {
        formattedWord.append(words[index] + DELIMITER);
        index++;
      }
      formattedWord = formattedWord.charAt(formattedWord.length() - 1) == ' ' ?
          formattedWord.deleteCharAt(formattedWord.length() - 1) : formattedWord;

      formattedStrings[formattedStringIndex] = padFormattedStringsAsPerTheRule(formattedWord, blockSize).toString();
      formattedWord = formattedWord.delete(0, formattedWord.length());
    }

    return formattedStrings;
  }

  private StringBuilder padFormattedStringsAsPerTheRule(StringBuilder formattedString, int blockSize) {
    int numberOfSpaces;
    numberOfSpaces = blockSize - formattedString.length();
    if (numberOfSpaces > 0)
      formattedString = fillInputWithSpaces(formattedString, numberOfSpaces, blockSize);
    return formattedString;
  }

  private StringBuilder fillInputWithSpaces(StringBuilder formattedString, int numberOfSpaces, int blockSize) {
    String[] split = formattedString.toString().split(DELIMITER);
    while (split.length > 1 && numberOfSpaces > 0) {
      for (int index = 0; index < split.length - 1; index++) {
        split[index] = split[index].concat(DELIMITER);
        numberOfSpaces--;
      }
    }
    formattedString = formattedString.delete(0, formattedString.length());
    for (int index = 0; index < split.length; index++)
      formattedString.append(split[index]);
    if (formattedString.length() != blockSize)
      formattedString = formatSpecialCaseStrings(formattedString, blockSize - formattedString.length());
    return formattedString;
  }

  private StringBuilder formatSpecialCaseStrings(StringBuilder formattedString, int numberOfSpaces) {
    while (numberOfSpaces > 0) {
      formattedString.append(DELIMITER);
      numberOfSpaces--;
    }
    return formattedString;
  }
}
