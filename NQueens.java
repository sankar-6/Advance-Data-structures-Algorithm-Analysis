package Datastructures;

import java.util.Arrays;

class NQueens {
    static int[] x; // Array to store the positions of queens in each row

    // Function to solve the N-Queens problem
    public static void NQueens(int k, int n) {
        for (int i = 1; i <= n; i++) { // Check all columns
            if (place(k, i)) { // Check if placing the queen is valid
                x[k] = i; // Place the queen in column i
                if (k == n) { // All queens placed
                    printSolution(n); // Print the solution without zeros
                } else {
                    NQueens(k + 1, n); // Recur for the next row
                }
            }
        }
    }

    // Function to check if placing a queen at position (k, i) is valid
    public static boolean place(int k, int i) {
        for (int j = 1; j < k; j++) {
            // Check if two queens are in the same column or diagonal
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }

    // Function to print the solution in the desired format
    public static void printSolution(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 8; // Change this to solve for different N (e.g., 4, 8, etc.)
        x = new int[n + 1]; // Initialize the array to store queen positions
        NQueens(1, n); // Start solving from the first row
    }
}
