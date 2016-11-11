/**
 * Created by Deepankit on 11/6/2016.
 */
public class Palindrome {
  private static final String REGEX = "[^a-z]+";

  public static void main(String[] args) {
    Palindrome palindrome = new Palindrome();
    System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
  }

  /*
  Hard check to see if a string is fully palindrome. (chars [a-z] and [A-Z] and delimiters are considered to see if a string
  is palindrome or not)
   */
  private boolean isPalindrome(String input) {
    input = removeExtraChars(input);
    int length = input.length();
    for (int index = 0; index < length / 2; index++)
      if (input.charAt(index) != input.charAt(length - 1 - index))
        return false;
    return true;
  }

  private String removeExtraChars(String input) {
    return input.toLowerCase().replaceAll(REGEX, "");
  }
}
