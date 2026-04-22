import java.util.Scanner;

public class ex66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số hàng: ");
        int rows = sc.nextInt();

        System.out.print("Nhập số cột: ");
        int cols = sc.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];

        System.out.println("Nhập ma trận 1:");
        inputMatrix(sc, matrix1);

        System.out.println("Nhập ma trận 2:");
        inputMatrix(sc, matrix2);

        int[][] sumMatrix = addMatrix(matrix1, matrix2);

        System.out.println("Tổng hai ma trận:");
        printMatrix(sumMatrix);

        sc.close();
    }

    public static void inputMatrix(Scanner sc, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + (i + 1) + "][" + (j + 1) + "] = ");
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    public static int[][] addMatrix(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}