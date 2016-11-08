import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deepankit on 11/6/2016.
 */
public class PrimeNumber {

  public static void main(String[] args) {
    PrimeNumber primeNumber = new PrimeNumber();
    List<Integer> primeIntegers = primeNumber.printPrimeLessThanGivenInput(100);
    displayOutput(primeIntegers);
  }

  private static void displayOutput(List<Integer> primeIntegers) {
    primeIntegers.forEach(System.out::println);
  }

  private List<Integer> printPrimeLessThanGivenInput(int input) {
    List<Integer> primeNumbers = new ArrayList<>();
    for (int index = 2; index <= input; index++)
      if (isPrimeMethodThree(index))
        primeNumbers.add(index);
    return primeNumbers;
  }

  /*
  Naive method. Avoid using this as this requires more computation.
   */
  private boolean isPrimeMethodOne(int input) {
    for (int index = 2; index < input; index++)
      if (input % index == 0)
        return false;
    return true;
  }

  /*
  If a number can be divided by any value within range 2 to square root of the given number, then its not prime.
   This trick provides fast computation.
   Better than isPrimeMethodOne
   */
  private boolean isPrimeMethodTwo(int input) {
    int range = (int) Math.sqrt(input);
    for (int index = 2; index <= range; index++)
      if (input % index == 0)
        return false;
    return true;
  }

  /*
  This method uses the fact that if a number is %2==0, its not prime.
  Once this check passes, we take square root of the number to calculate the range.
  Increment loop index with 2 to elimitnate trivial check.
  Better performance than isPrimeMethodTwo described above
   */
  public boolean isPrimeMethodThree(int input) {
    if (input > 2 && input % 2 == 0)
      return false;
    int range = (int) Math.sqrt(input);
    for (int number = 3; number <= range; number += 2)
      if (input % number == 0)
        return false;
    return true;
  }
}
