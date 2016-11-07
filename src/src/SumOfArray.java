/**
 * Created by Deepankit on 11/7/2016.
 */
public class SumOfArray {
  public static void main(String[] args) {
    SumOfArray sumOfArray = new SumOfArray();
    int[] input = new int[]{1, 2, 3, 4};
    sumOfArray.findSum(input);
  }

  private int findSum(int[] input) {
    int sum = 0;
    for (int index = 0; index < input.length; index++)
      sum += input[index];
    return sum;
  }
}
