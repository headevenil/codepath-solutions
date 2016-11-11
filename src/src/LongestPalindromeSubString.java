/**
 * Created by Deepankit on 11/9/2016.
 */
public class LongestPalindromeSubString {
  public static void main(String[] args) {
    LongestPalindromeSubString longestPalindromeSubString = new LongestPalindromeSubString();
    String longestPalindrome = longestPalindromeSubString.findLargestPalindromeSubString("");
    System.out.println(longestPalindrome);
  }

  private String findLargestPalindromeSubString(String input) {
    int leftIndex;
    int rightIndex;
    int startIndex = 0;
    int maxLength = 0;
    for (int index = 1; index < input.length(); index++) {
      leftIndex = index - 1;
      rightIndex = index;
      while (leftIndex >= 0 && rightIndex < input.length() && input.charAt(leftIndex) == input.charAt(rightIndex)) {
        if (maxLength < rightIndex - leftIndex + 1) {
          maxLength = rightIndex - leftIndex + 1;
          startIndex = leftIndex;
        }
        leftIndex--;
        rightIndex++;
      }

      leftIndex = index - 1;
      rightIndex = index + 1;
      while (leftIndex >= 0 && rightIndex < input.length() && input.charAt(leftIndex) == input.charAt(rightIndex)) {
        if (maxLength < rightIndex - leftIndex + 1) {
          maxLength = rightIndex - leftIndex + 1;
          startIndex = leftIndex;
        }
        leftIndex--;
        rightIndex++;
      }
    }
    return input.substring(startIndex, maxLength + startIndex);
  }
}
