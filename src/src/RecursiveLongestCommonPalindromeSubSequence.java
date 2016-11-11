/**
 * Created by Deepankit on 11/6/2016.
 */
public class RecursiveLongestCommonPalindromeSubSequence {
  public static void main(String[] args) {
    RecursiveLongestCommonPalindromeSubSequence recursiveLongestCommonPalindromeSubSequence = new RecursiveLongestCommonPalindromeSubSequence();
    String inputString = "BBABCBCAB";
    int commonPalindrome = recursiveLongestCommonPalindromeSubSequence.findLongestCommonPalindrome(inputString, 0, inputString.length() - 1);
    System.out.println(commonPalindrome);
  }

  /*
  Rnning time is 2^n.
   */
  private int findLongestCommonPalindrome(String inputString, int startIndex, int endIndex) {
    if (startIndex == endIndex)
      return 1;
    if (inputString.charAt(startIndex) == inputString.charAt(endIndex) && (startIndex + 1 == endIndex))
      return 2;
    if (inputString.charAt(startIndex) == inputString.charAt(endIndex))
      return 2 + findLongestCommonPalindrome(inputString, startIndex + 1, endIndex - 1);
    else {
      return Math.max(findLongestCommonPalindrome(inputString, startIndex, endIndex - 1),
          findLongestCommonPalindrome(inputString, startIndex + 1, endIndex));
    }
  }
}