import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deepankit on 11/7/2016.
 */
public class PrimeNumberUsingSieveOfEratosthenes {
  public static void main(String[] args) {
    PrimeNumberUsingSieveOfEratosthenes primeNumberUsingSieveOfEratosthenes = new PrimeNumberUsingSieveOfEratosthenes();
    List<Integer> primeNumbers = primeNumberUsingSieveOfEratosthenes.findPrimeNumbersWithInGivenRangeMethodFour(1000000);
    primeNumberUsingSieveOfEratosthenes.printResult(primeNumbers);

  }

  private void printResult(List<Integer> primeNumbers) {
    primeNumbers.forEach(System.out::println);
  }

  /* Popularly known as Sieve Of Eratosthenes algorithm.
   O(nloglog(n)) time complexity
   O(n) space complexity.
    */
  private List<Integer> findPrimeNumbersWithInGivenRangeMethodOne(int input) {
    boolean[] isPrime = new boolean[input + 1];
    for (int index = 2; index <= input; index++)
      isPrime[index] = true;

    ArrayList<Integer> primeNumbers = new ArrayList<>();
    for (int index = 2; index <= Math.sqrt(input); index++)
      if (isPrime[index])
        for (int markerIndex = index * index; markerIndex <= input; markerIndex += index)
          isPrime[markerIndex] = false;

    for (int index = 0; index <= input; index++)
      if (isPrime[index])
        primeNumbers.add(index);
    return primeNumbers;
  }

    /* Modification over Sieve Of Eratosthenes algorithm.
   This approaches uses the fact that all the prime numbers can be expressed in form of 6K + 1 or 6k -1.
   Then we will apply Sieve Of Eratosthenes algorithm.
   Time complexity less than O(nloglog(n))
   O(n) space complexity.
    */

  private List<Integer> findPrimeNumbersWithInGivenRangeMethodTwo(int input) {
    boolean[] isPrime = new boolean[input + 1];
    for (int index = 2; index <= 3; index++)
      isPrime[index] = true;

    for (int index = 5; index <= input; index++) {
      if ((index + 1) % 6 == 0 || (index - 1) % 6 == 0)
        isPrime[index] = true;
    }

    ArrayList<Integer> primeNumbers = new ArrayList<>();
    for (int index = 2; index <= Math.sqrt(input); index++)
      if (isPrime[index])

        for (int markerIndex = index * index; markerIndex <= input; markerIndex += index)
          isPrime[markerIndex] = false;

    for (int index = 0; index <= input; index++)
      if (isPrime[index])
        primeNumbers.add(index);
    return primeNumbers;
  }

      /* Modification over MethodTwo in terms of space complexity.
   This approaches uses the fact that all the prime numbers can be expressed in form of 6K + 1 or 6k -1.
   Then we will filter values which satisfies condtion of 0 mod if divided  by 2,3,5,7
   O(k) space complexity where k is probable prime numbers.
    */

  private List<Integer> findPrimeNumbersWithInGivenRangeMethodThree(int input) {
    List<Integer> probablePrimeNumbers = new ArrayList<>();
    for (int index = 2; index <= 3; index++)
      probablePrimeNumbers.add(index);

    for (int index = 5; index <= input; index++) {
      if ((index + 1) % 6 == 0 || (index - 1) % 6 == 0)
        probablePrimeNumbers.add(index);
    }
    List<Integer> primeNumbers = new ArrayList<>();
    boolean isPrime;
    for (int number : probablePrimeNumbers) {
      isPrime = true;
      for (int index = 2; index <= Math.sqrt(input); index++) {
        if (index != number && number % index == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime)
        primeNumbers.add(number);
    }
    return primeNumbers;
  }

      /* Modification over MethodThree in terms of space complexity.
   This approaches uses the fact that all the prime numbers can be expressed in form of 6K + 1 or 6k -1.
   Then we will filter values which satisfies condtion of 0 mod if divided  by 2,3,5,7
   O(k) space complexity where k is prime numbers.
    */

  private List<Integer> findPrimeNumbersWithInGivenRangeMethodFour(int input) {
    List<Integer> primeNumbers = new ArrayList<>();
    if (input > 0 && input <= 2)
      primeNumbers.add(2);
    else if (input >= 2 && input < 5) {
      primeNumbers.add(2);
      primeNumbers.add(3);
    } else {
      boolean isPrime;
      primeNumbers.add(2);
      primeNumbers.add(3);
      for (int index = 5; index <= input; index++) {
        isPrime = true;
        if ((index + 1) % 6 == 0 || (index - 1) % 6 == 0) {
          for (int secondIndex = 2; secondIndex <= Math.sqrt(input); secondIndex++)
            if (index != secondIndex && index % secondIndex == 0) {
              isPrime = false;
              break;
            }
          if (isPrime)
            primeNumbers.add(index);
        }
      }

    }
    return primeNumbers;
  }
}
