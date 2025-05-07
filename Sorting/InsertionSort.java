import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) { // Start from 1
            int current = arr[i];  // Store current element
            int prev = i - 1;

            // Shift elements to the right to make space for the current element
            while (prev >= 0 && arr[prev] > current) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // Insert the current element at the correct position
            arr[prev + 1] = current;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = scan.nextInt();
        }

        scan.close();

        System.out.println("\nOriginal array: ");
        printArray(arr);

        insertionSort(arr, n);

        System.out.println("Sorted array: ");
        printArray(arr);
    }
}
