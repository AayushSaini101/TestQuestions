import java.util.*;
import java.io.*;

public class Matrix {

    Scanner scan;

    Matrix() {
        scan = new Scanner(System.in);

    }

    // Function to insert elements
    public void insertElements(int matrix[][]) {

        for (int i = 0; i < matrix.length; ++i) {

            for (int j = 0; j < matrix[0].length; ++j) {

                matrix[i][j] = scan.nextInt();
            }
        }

    }

    // Method to find transpose
    public int[][] matrixTranspose(int matrix[][]) {

        int transpose[][] = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {

            for (int j = 0; j < matrix.length; ++j) {

                transpose[i][j] = matrix[j][i];
            }
        }

        return transpose;

    }

    public int[][] matrixMultiply(int firstMatrix[][], int secondMatrix[][]) {

        int matrix[][] = new int[firstMatrix.length][firstMatrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {

            for (int j = 0; j < matrix.length; ++j) {

                for (int k = 0; k < matrix.length; ++k) {

                    matrix[i][j] += firstMatrix[i][j] * secondMatrix[j][k];

                }

            }
        }

        return matrix;

    }

    public void matrixPrint(int matrix[][]) {

        for (int i = 0; i < matrix.length; ++i) {

            for (int j = 0; j < matrix.length; ++j) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Matrix ob = new Matrix();

        int row = scan.nextInt();

        int col = scan.nextInt();

        if (row != col && (row != 3 || row != 4)) {

            System.out.println("Please enter the correct matrix dimensions");

        }

        int matrix[][] = new int[row][col];

        ob.insertElements(matrix);

        int updatedMatrix[][] = ob.matrixMultiply(ob.matrixTranspose(matrix), matrix);

        ob.matrixPrint(updatedMatrix);

    }

}
