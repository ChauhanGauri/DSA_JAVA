import java.util.Scanner;

public class QuickSort {
    // Method to partition the array
    public static int partition(int[]arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            // If current element is smaller than pivot, swap it
            if(arr[j]<pivot){
                i++;
                //swap
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        // Swap pivot element to correct position
        i++;
        int temp=arr[i];
        arr[i]=pivot;
        arr[high]=temp;
        return i;
    }

    public static void quickSort(int[]arr,int low,int high){
        if(low<high){
            int pidx=partition(arr,low,high);
            // Recursively sort elements before and after partition
            quickSort(arr,low,pidx-1);
            quickSort(arr,pidx+1,high);
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

        quickSort(arr,0, n-1);

        System.out.println("Sorted array: ");
        printArray(arr);
    }
}
