import static java.lang.Math.max;

/**
 * Created by Deepankit on 11/6/2016.
 */
public class IterativeLongestPalindromeSequence {

  /*
  O(n^2) space and time complexity. Variation of longest common subsequence.
   */
  private int longestCommonPalindromeMethodOne(String input) {
    int[][] palindromeLength = new int[input.length() + 1][input.length() + 1];
    int maxLength = Integer.MIN_VALUE;
    char[] firstInputCharArray = input.toCharArray();
    char[] firstInputReverseCharArray = new StringBuilder(input).reverse().toString().toCharArray();
    for (int firstIndex = 0; firstIndex < input.length(); firstIndex++)
      for (int secondIndex = 0; secondIndex < input.length(); secondIndex++) {
        if (firstInputCharArray[firstIndex] == firstInputReverseCharArray[secondIndex])
          palindromeLength[firstIndex + 1][secondIndex + 1] = palindromeLength[firstIndex][secondIndex] + 1;
        else {
          palindromeLength[firstIndex + 1][secondIndex + 1] = max(palindromeLength[firstIndex][secondIndex + 1], palindromeLength[firstIndex + 1][secondIndex]);
        }
      }
    for (int firstIndex = 0; firstIndex <= input.length(); firstIndex++)
      for (int secondIndex = 0; secondIndex <= input.length(); secondIndex++) {
        if (maxLength < palindromeLength[firstIndex][secondIndex])
          maxLength = palindromeLength[firstIndex][secondIndex];
      }
    return maxLength;
  }

  /*
    O(n^2) running and space complexity but we will fill only upper diagonal element.
    Inspired by matrix chain multiplication.
     */
  public int longestCommonPalindromeMethodTwo(String input) {

    char[] inputCharacters = input.toCharArray();
    int[][] palindromeLength = new int[inputCharacters.length][inputCharacters.length];

    for (int index = 0; index < inputCharacters.length; index++) {
      palindromeLength[index][index] = 1;
    }

    for (int firstIndex = 2; firstIndex <= inputCharacters.length; firstIndex++) {
      for (int secondIndex = 0; secondIndex <= palindromeLength.length - firstIndex; secondIndex++) {
        int windowLength = secondIndex + firstIndex - 1;
        if (inputCharacters[secondIndex] == inputCharacters[windowLength] && firstIndex == 2) {
          palindromeLength[secondIndex][windowLength] = 2;
        } else if (inputCharacters[secondIndex] == inputCharacters[windowLength]) {
          palindromeLength[secondIndex][windowLength] = palindromeLength[secondIndex + 1][windowLength - 1] + 2;
        } else {
          palindromeLength[secondIndex][windowLength] = Math.max(palindromeLength[secondIndex + 1][windowLength], palindromeLength[secondIndex][windowLength - 1]);
        }
      }
    }
    return palindromeLength[0][palindromeLength.length - 1];

  }

}
