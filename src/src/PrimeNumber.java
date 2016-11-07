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
      if (isPrime(index))
        primeNumbers.add(index);
    return primeNumbers;
  }

  /*
  If a number can be divided by any value within range 2 to square root of the given number, then its not prime.
   This trick provides very fast computation.
   */
  private boolean isPrime(int input) {
    int range = (int) Math.sqrt(input);
    for (int index = 2; index <= range; index++)
      if (input % index == 0)
        return false;
    return true;
  }
}
