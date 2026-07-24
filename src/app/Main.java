package app;
import java.util.*;

public class Main {
    public static final byte MIN = 1;
    public static final byte MAX = 50;
    public static final int SIZE = 4;

    public static void main(String[] args) {
        int[][] matrix = new int[SIZE][SIZE];

        fillMatrixWithRandoms(matrix);
        printMatrix(matrix);

        sumOddRows(matrix);
        sumEvenRows(matrix);

        multiplyOddColumns(matrix);
        multiplyEvenColumns(matrix);
        System.out.println();

        isMagicSquare(matrix);
    }

    public static void isMagicSquare(int[][] matrix) {
        int[] sumsOfRows = new int[SIZE];
        int[] sumsOfColumns = new int[SIZE];
        int[] sumsOfDiagonals = new int[2];

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                sumsOfRows[row] += matrix[row][col];
                sumsOfColumns[row] += matrix[col][row];

                if (col == row) {
                    sumsOfDiagonals[0] += matrix[row][col];
                }
            }

            if (row > 0 && sumsOfRows[row] != sumsOfRows[row-1]) {
                System.out.println("This matrix is not magic square!");
                return;
            }
        }

        sumsOfDiagonals[1] += matrix[SIZE-1][0];
        sumsOfDiagonals[1] += matrix[1][2];
        sumsOfDiagonals[1] += matrix[2][1];
        sumsOfDiagonals[1] += matrix[0][SIZE-1];

        if (sumsOfDiagonals[0] != sumsOfDiagonals[1]) {
            System.out.println("This matrix is not magic square!");
            return;
        }

        for (int i = 0; i < SIZE; i++) {
           for (int j = 0; j < SIZE; j++) {
               if (sumsOfRows[i] != sumsOfColumns[j] || sumsOfColumns[j] != sumsOfDiagonals[0]) {
                   System.out.println("This matrix is not magic square!");
                   return;
               }
           }
        }
        System.out.println("This matrix is magic square!");
    }

    public static void multiplyOddColumns(int[][] matrix) {
        long result = 1L;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (col % 2 != 0) {
                    continue;
                }

                result *= matrix[row][col];
            }

        }
        System.out.printf("Multiplication value result in the odd rows (row %s) is: %d%n", getIndexes("odd"), result);
    }

    public static void multiplyEvenColumns(int[][] matrix) {
        long result = 1L;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (col % 2 == 0) {
                    continue;
                }
                result *= matrix[row][col];
            }

        }
        System.out.printf("Multiplication value result in the even rows (row %s) is: %d%n", getIndexes("even"), result);
    }

    public static int sumOddRows(int[][] matrix) {
        int result = 0;
        for (int row = 0; row < SIZE; row++) {
            if (row % 2 != 0) {
                continue;
            }

            for (int col = 0; col < SIZE; col++) {
                result += matrix[row][col];
            }

        }
        System.out.printf("Sum in the odd rows (row %s) is: %d%n", getIndexes("odd"), result);
        return result;
    }

    public static int sumEvenRows(int[][] matrix) {
        int result = 0;
        for (int row = 0; row < SIZE; row++) {
            if (row % 2 == 0) {
                continue;
            }

            for (int col = 0; col < SIZE; col++) {
                result += matrix[row][col];
            }

        }
        System.out.printf("Sum in the even rows (row %s) is: %d%n", getIndexes("even"), result);
        return result;
    }

    public static void fillMatrixWithRandoms(int[][] matrix) {
       Random random = new Random();

       for (int row = 0; row < SIZE; row++) {
           for (int col = 0; col < SIZE; col++) {
                matrix[row][col] = random.nextInt(MIN, MAX);
           }
       }
    }

    public static void printMatrix(int[][] matrix) {
        System.out.print("Matrix " + SIZE + "x" + SIZE + ":");
        for (int row = 0; row < SIZE; row++) {
            System.out.println();
            for (int col = 0; col < SIZE; col++) {
                System.out.print(matrix[row][col] + " ");
            }
        }
        System.out.printf("%n%n");
    }


    private static String getIndexes(String rowType) {
        String rows = "";
        for (int i = 0; i < SIZE; i++) {
            if (rowType.equalsIgnoreCase("even") == ((i + 1) % 2 == 0)) {
                rows += i + ", ";
            }
        }
        int index = rows.lastIndexOf(", ");
        return rows.substring(0, index);
    }
}

