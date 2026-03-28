import java.util.Arrays;
import java.util.Scanner;

public class ex65 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử mảng: ");
        int n = sc.nextInt();
        double[] arr = new double[n];
        System.out.println("Nhập " + n + " phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        double sum = 0;
        for (double x : arr) {
            sum += x;
        }
        double average = sum / n;
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));
        System.out.println("Tổng: " + sum);
        System.out.println("Trung bình: " + average);
        sc.close();
    }
}