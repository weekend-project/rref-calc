import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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

        for (int row = 0; row < matrix.length; row++) { // iterates through each row, m times
            System.out.print("Row " + (row + 1) + ": "); // will always prompt for user input m times
            for (int col = 0; col < matrix[0].length; col++) { // iterates through each column, n times
                matrix[row][col] = reader.nextInt(); // assigns the next int in the scanner object to spot [row][col]
            }
        }

        System.out.println();
        System.out.println("Your matrix...");
        printMatrix(matrix);
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(getIndexOfRowsWithLCD(matrix));

        }

    }

    /**
     * This method returns an ArrayList that contains the index of each row that is all even
     *
     * @param matrix this is the matrix that the user creates
     * @return returns an ArrayList of int that
     */

    public static ArrayList<Integer> getIndexOfRowsWithLCD(int[][] matrix) {
        ArrayList<Integer> indexOfRowsLCD = new ArrayList<Integer>(); // creates the empty ArrayList
        for (int i = 0; i < matrix.length; i++) { // repeats for every row in the matrix
            if (isDivisibleByLCD(matrix, i)) { // checks if each row has an LCD
                indexOfRowsLCD.add(i); // if true, adds that index to the ArrayList
            }
        }
        return indexOfRowsLCD;
    }

    /**
     * Prints the given matrix in a square format
     * <p>
     * For each row within "matrix", print each int within the current row
     * //TODO will need to fix format when ints are not single-digits
     *
     * @param matrix this is the matrix that the user creates
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) { // for every row within the multidimensional matrix...
            for (int b : row) // iterate through each int within that row...
                System.out.print("[" + b + "]"); // print each int with brackets around it
            System.out.println();
        }
    }

    /**
     * Determines if the given row contains all even entries
     * <p>
     * Takes in the matrix and an int, runs through only the row corresponding with the int
     * <p>
     * //TODO need to test if you can pass in just one row from the multidimensional matrix
     *
     * @param matrix this is the matrix that the user creates
     * @param row    this is the number of rows that the user enters
     * @return returns true only if the respective row contains all even entries
     */

    public static boolean rowIsEven(int[][] matrix, int row) {
        boolean isEven = false;
        int evenCounter = 0;
        for (int i = 0; i < matrix[0].length; i++) { // iterates through the row (matrix[0].length will always be correct)
            int evenCheck = matrix[row][i] % 2; // checks each int at [row][col] is even or not
            if (evenCheck == 0) {
                evenCounter++; // keeps track of even ints in each row
                if (evenCounter == matrix[0].length) { // if evenCounter matches the length of the row, that means they are all even
                    isEven = true;
                }
            }
        }
        return isEven;
    }

    public static boolean isDivisibleByLCD(int[][] matrix, int row) {
        boolean isDivisible = false;
        int counter = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if ((matrix[row][i]) % (getMinInt(matrix, i)) == 0) {
                counter++;
                if (counter == matrix[0].length) {
                    isDivisible = true;
                }
            }
        }
        return isDivisible;
    }

    /**
     * Returns the minimum int within the given row of the multidimensional matrix
     * <p>
     * This is needed to determine the LCD
     * <p>
     * //TODO need to find out if you can pass int just one row of the matrix (single array)
     * //TODO what if the row contains a zero? Need to ignore zeros
     *
     * @param matrix this is the matrix that the user creates
     * @param row    this is the number of rows that the user enters
     * @return returns an int that is the smallest number within corresponding row
     */
    public static int getMinInt(int[][] matrix, int row) {
        int min = 0; // sets min to the first entry in the row
        for (int i = 0; i < matrix[0].length; i++) { // loops through all of the row
            if (Math.abs(matrix[row][i]) >= 2 && Math.abs(matrix[row][i]) < min) { // ignores any entry that is 0 or 1
//                min = Math.abs(matrix[row][i]); // sets min to the first entry that is not 0 or 1
                if (Math.abs(matrix[row][i]) < min) { // true if the next entry is less than the current min
                    min = matrix[row][i]; // changes min to that entry
                }
            }
        }
        return min;
    }

}

