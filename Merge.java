package Datastructures;
import java.util.Scanner;
public class Merge {
    public static void merge(int a[], int low, int mid, int high) {
        int i=low;
        int j=mid+1;
        int k=low;
        while((i<=mid)&&(j<=high)){
            if(a[i]>a[j]){
                a[k]=a[i];
                i++;
            }
            else{
                a[k]=a[j];
                j++;
            }
            k++;
        }
        if(i>mid){
            while(j<=high){
                a[k]=a[j];
                j++;
                k++;
            }
        }
        else{
            while(i<=mid){
                a[k]=a[i];
                i++;
                k++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter Array Elements:-");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, arr.length - 1);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l > r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1,r);
            merge(arr, l, mid, r);
        }
    }
}