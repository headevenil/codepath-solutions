/**
 * Created by Deepankit on 11/6/2016.
 */
public class LongestCommonPrefix {
  public static void main(String[] args) throws Exception {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    String[] input = new String[]{"geeksforgeeks", "geeksforgee", "geeks", "gawk"};
    longestCommonPrefix.validate(input);
    String commonPrefix = longestCommonPrefix.findLargestCommonPrefix(input);
    System.out.println(commonPrefix);
  }

  private String findLargestCommonPrefix(String[] input) {
    int smallestStringIndex = findSmallestStringIndex(input);
    int matched;
    StringBuilder output = new StringBuilder();
    for (int index = 0; index < input[smallestStringIndex].toCharArray().length; index++) {
      matched = 0;
      for (int stringInputIndex = 0; stringInputIndex < input.length; stringInputIndex++)
        if (input[smallestStringIndex].charAt(index) == input[stringInputIndex].charAt(index)) {
          ++matched;
        }

      if (matched == input.length)
        output.append(input[smallestStringIndex].charAt(index));
      else
        return output.toString();
    }
    return output.toString();
  }

  private int findSmallestStringIndex(String[] input) {
    int minLengthStringIndex = 0;
    for (int index = 0; index < input.length; index++) {
      if (input[minLengthStringIndex].length() > input[index].length())
        minLengthStringIndex = index;
    }
    return minLengthStringIndex;
  }

  private void validate(String[] input) throws Exception {
    if (input == null || input.length == 0)
      throw new Exception("invalid input");
  }
}
