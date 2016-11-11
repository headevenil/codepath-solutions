import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Deepankit on 11/4/2016.
 */
public class RemoveDuplicates {

  private static final int FILLER_ELEMENT = Integer.MIN_VALUE;

  public static void main(String[] args) {
    int output;
    RemoveDuplicates removeDuplicates = new RemoveDuplicates();
    output = removeDuplicates.countDistinctElementsMethodOne(new int[]{1, 1, 3, 2, 2, 7, 2, 13, 12, 93, 22, 13});
    System.out.println("Method One Output: " + output);
    output = removeDuplicates.countDistinctElementsMethodTwo(new int[]{1, 1, 3, 2, 2, 7, 2, 13, 12, 93, 22, 13});
    System.out.println("Method Two Output: " + output);
    output = removeDuplicates.countDistinctElementsMethodThree(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3});
    System.out.println("Method Three Output: " + output);
  }

  /*
    Generic method when given array is sorted
    O(n) solution without using any other data structure. Space complexity O(1)
     */
  private int countDistinctElementsMethodThree(int[] input) {
    int firstIndex = 0;
    int seconIndex = 0;
    while (seconIndex < input.length) {
      if (input[firstIndex] == input[seconIndex])
        seconIndex++;
      else {
        firstIndex++;
        input[firstIndex] = input[seconIndex];
        seconIndex++;
      }
    }
    for (int index = firstIndex + 1; index < input.length; index++)
      input[index] = FILLER_ELEMENT;
    return firstIndex + 1;
  }

  /*
  Generic method when given array is not sorted
  O(nlogn) solution without using any other data structure. Constant space complexity.
   */
  private int countDistinctElementsMethodTwo(int[] input) {
    Arrays.sort(input);
    if (input.length < 2)
      return 1;

    int firstIndex = 0;
    int secondIndex = 1;

    while (secondIndex < input.length) {
      if (input[secondIndex] == input[firstIndex]) {
        secondIndex++;
      } else {
        firstIndex++;
        input[firstIndex] = input[secondIndex];
        secondIndex++;
      }
    }

    for (int index = firstIndex + 1; index < input.length; index++)
      input[index] = FILLER_ELEMENT;

    return firstIndex + 1;
  }

  /*
  Generic solution when given array is not sorted.
  O(n) time complexity and O(n) space complexity.
   */
  private int countDistinctElementsMethodOne(int[] input) {
    Set<Integer> distinctNumbers = new LinkedHashSet<>();
    for (int index = 0; index < input.length; index++)
      distinctNumbers.add(input[index]);
    return distinctNumbers.size();
  }

}
