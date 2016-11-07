import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Deepankit on 11/4/2016.
 */
public class RemoveDuplicates {

  public static void main(String[] args) {
    int[] output;
    RemoveDuplicates removeDuplicates = new RemoveDuplicates();
    output = removeDuplicates.removeDuplicatesMethodOne(new int[]{1, 1, 1, 1, 2, 1, 2, 3, 2, 3, 2, 3});
    System.out.println("Method One Output");
    displayOutput(output);
    System.out.println("Method Two Output");
    output = removeDuplicates.removeDuplicatesMethodTwo(new int[]{1, 1, 1, 1, 2, 1, 2, 3, 2, 3, 2, 3});
    displayOutput(output);
  }

  private static void displayOutput(int[] output) {
    for (int index = 0; index < output.length; index++) {
      System.out.println(output[index]);
    }
  }

  /*
  O(nlogn) solution without using any other data structure.
   */
  private int[] removeDuplicatesMethodTwo(int[] input) {
    Arrays.sort(input);
    if (input.length < 2)
      return input;

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

    int[] output = Arrays.copyOf(input, firstIndex + 1);

    return output;
  }

  /*
  O(n) time complexity and O(n) space complexity
   */
  private int[] removeDuplicatesMethodOne(int[] input) {
    HashSet<Integer> distinctNumbers = new HashSet<>();
    for (int index = 0; index < input.length; index++)
      distinctNumbers.add(input[index]);
    return convertSetToArray(distinctNumbers);
  }

  private int[] convertSetToArray(HashSet<Integer> distinctNumbers) {
    int[] distinctInput = new int[distinctNumbers.size()];
    int index = 0;
    for (Integer i : distinctNumbers) {
      distinctInput[index++] = i;
    }
    return distinctInput;
  }
}
