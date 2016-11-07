/**
 * Created by Deepankit on 11/6/2016.
 */
public class Palindrome {
  public static void main(String[] args) {
    Palindrome palindrome = new Palindrome();
    System.out.println(palindrome.isPalindrome("race a ecar"));
  }

  private boolean isPalindrome(String input) {
    int length = input.length();
    for (int index = 0; index < length / 2; index++)
      if (input.charAt(index) != input.charAt(length - 1 - index))
        return false;
    return true;
  }
}
