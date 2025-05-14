package Adsaa;
import java.util.*;

class Quick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array elements:-");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Before sorting:-" + Arrays.toString(arr));
        long start = System.nanoTime();
        quickSort(arr, 0, n - 1);
        long end = System.nanoTime();
        System.out.println("After sorting:-" + Arrays.toString(arr));
        System.out.println("Time taken: " + (end - start) + "ns");
    sc.close();
    }

    public static void quickSort(int a[], int low, int high) {
        if (low < high) {
            int j = partition(a, low, high);
            quickSort(a, low, j - 1);
            quickSort(a, j + 1, high);
        }
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[low]; 
        int i = low + 1; 
        int j = high;
        while (true) {
            while (i <= high && a[i] <= pivot) {
                i++;
            }
            while (a[j] > pivot && j >= low) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            } else {
                break;
            }
        }
        int temp = a[low];
        a[low] = a[j];
        a[j] = temp;

        return j;
    }
}
