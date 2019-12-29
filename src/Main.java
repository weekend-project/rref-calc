import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the number of rows (M): ");
        int m = reader.nextInt();
        System.out.print("Enter the number of columns (N): ");
        int n = reader.nextInt();
        int[][] matrix = new int[m][n];
        System.out.println();
        System.out.println("Enter the values in each row separated by spaces...");

        /*
           Outer for-loop prints the dialogue m number of times, m is the number of rows entered by the user previously
           Inner for-loop takes each int separated by a space in the scanner object and assigns it to the next position
           in the multidimensional array named "matrix"
         */

        //FIXME If the user enters all entries in one row, it will still prompt for next rows even though the scanner
        // object has everything it needs. This should be addressed by either preventing more than n entries, or
        // removing the unnecessary prompts since the scanner object is not empty.

        for (int row = 0; row < matrix.length; row++) {
            System.out.print("Row " + (row + 1) + ": ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = reader.nextInt();
            }
        }

        System.out.println();
        System.out.println("Your matrix:");
        printMatrix(matrix);

    }

    /*
        Prints the given matrix in a square format

        For each row within "matrix", print each int within the current row
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int b : row)
                System.out.print("[" + b + "]");
            System.out.println();
        }
    }

    /*
        Determines if the given row is contains all even entries

        Takes in the matrix and an int, runs through only the row corresponding with the int

        //TODO need to test if you can pass in just one from of the multidimensional matrix
     */

    public static boolean rowIsEven(int[][] matrix, int row) {
        boolean isEven = false;
        int evenCounter = 0;
        for (int i = 0; i < matrix[0].length; i++) { // iterates through the row
            int evenCheck = matrix[row][i] % 2; // checks each int at [row][col] is even or not
            if (evenCheck == 0) {
                evenCounter++; // keeps track of even ints in each row
                if (evenCounter == matrix[0].length) { // true means all entries in current row are even (0 doesn't matter)
                    isEven = true;
                }
            }
        }
        return isEven;
    }

    /*
        Returns the minimum int within the given row of the multidimensional matrix

        //TODO need to find out if you can pass int just one row of the matrix (single array)
     */
    public static int getMinInt(int[][] matrix, int row) {
        int min = matrix[row][0];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] < min) {
                min = matrix[row][i];
            }
        }
        return min;
    }

}

