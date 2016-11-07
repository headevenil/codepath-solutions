import java.util.Scanner;

/**
 * Created by Deepankit on 11/6/2016.
 */
public class PrintMatrixValuesInSpiralOrder {
  public static void main(String[] args) {
    PrintMatrixValuesInSpiralOrder printMatrixValuesInSpiralOrder = new PrintMatrixValuesInSpiralOrder();
    int rowLength = 4;
    int columnLength = 4;
    int[][] input = new int[rowLength][columnLength];
    printMatrixValuesInSpiralOrder.fillValues(input);
    printMatrixValuesInSpiralOrder.formSpiralOutput(input, 0, 0, rowLength - 1, columnLength - 1);
  }

  private void fillValues(int[][] input) {
    int terminatingCondition = input.length * input[0].length + 1;
    int count = 1;
    int rowIndex = 0;
    int columnIndex = 0;
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext() && count < terminatingCondition) {
      count++;
      if (columnIndex == input[0].length) {
        rowIndex++;
        columnIndex = 0;
      }
      input[rowIndex][columnIndex] = scanner.nextInt();
      columnIndex++;
    }
  }

  private void formSpiralOutput(int[][] input, int rowStartIndex, int columnStartIndex, int rowLength, int columnLength) {

    if (rowStartIndex > rowLength || columnStartIndex > columnLength)
      return;

    for (int towardsRight = columnStartIndex; towardsRight <= columnLength; towardsRight++)
      System.out.println(input[rowStartIndex][towardsRight]);
    for (int towardBottom = rowStartIndex + 1; towardBottom <= rowLength; towardBottom++)
      System.out.println(input[towardBottom][columnLength]);
    for (int towardsLeft = columnLength - 1; towardsLeft >= columnStartIndex; towardsLeft--)
      System.out.println(input[rowLength][towardsLeft]);
    for (int towardsUp = rowLength - 1; towardsUp > rowStartIndex; towardsUp--)
      System.out.println(input[towardsUp][rowStartIndex]);
    rowStartIndex++;
    columnStartIndex++;
    rowLength--;
    columnLength--;

    formSpiralOutput(input, rowStartIndex, columnStartIndex, rowLength, columnLength);
  }
}
