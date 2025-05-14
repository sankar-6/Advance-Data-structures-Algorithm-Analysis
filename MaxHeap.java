package Datastructures;

import java.util.ArrayList;
import java.util.*;
public class MaxHeap {
    public static void insert(ArrayList<Integer>a ,int item){
        a.add(item);
        int i=a.size()-1;
        while(i>0 && a.get(i)>a.get(i/2)){
            int temp=a.get(i);
            a.set(i,a.get(i/2));
            a.set(i/2,temp);
            i=i/2;
        }
    }
    public static int deleteMax(ArrayList<Integer> a){
        if(a.isEmpty()){
            System.out.println("Heap is empty");
            return -1;
        }
        int max=a.get(0);
        a.set(0,a.get(a.size()-1));
        a.remove(a.size()-1);
        if(!a.isEmpty()){
            adjust(a,0,a.size()-1);
        }
        return max;
    }
    public static void adjust(ArrayList<Integer> a,int i,int n){
        int j =2*i+1;
        int item =a.get(i);
        while(j<n){
            if(j+1<n && a.get(j)<a.get(j+1)){
                j=j+1;
            }
            if(item>=a.get(j)){
                break;
            }
            a.set(i,a.get(j));
            i=j;
            j=2*i+1;
        }
        a.set(i,item);
    }
    public static void heapify(ArrayList<Integer>a){
        for(int i=a.size()-1;i>=0;i--){
            adjust(a,i,a.size()-1);
        }
    }
    public static void heapSort(ArrayList<Integer> a){
        int n=a.size()-1;
        for(int i=a.size()-1;i>=0;i--){
            int temp=a.get(i);
            a.set(i,a.get(0));
            a.set(0,temp);
            adjust(a,0,i-1);
        }
    }
    public static int searchMax(ArrayList<Integer>a){
        return a.size()>0?a.get(0):-1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Elements");
        int n=sc.nextInt();
        System.out.println("Enter array elements");
        ArrayList<Integer>a=new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }
        System.out.println("Given array"+a);
        System.out.println("Heapifying the array");
        heapify(a);
        System.out.println("Heap array"+a);
        while(true){
            System.out.println("1.insert\n 2.DeleteMax \n 3.SearchMax \n 4.Heapsort\n 5.Exit");
            int choice =sc.nextInt();
            switch(choice){
                case 1->{
                    System.out.println("enter the number");
                    int item=sc.nextInt();
                    insert(a, item);
                    System.out.println("After Insertion"+a);
                }
                case 2->{
                    System.out.println(deleteMax(a));
                    if(deleteMax(a)!=-1){
                        System.out.println("After Deletion "+a);
                    }
                }
                case 3->{
                    System.out.println("Max Element is "+searchMax(a));
                }
                case 4->{
                    System.out.println("Before Sorting"+a);
                    heapSort(a);
                    System.out.println("After Sorting"+a);
                }
                case 5->{
                    System.out.println("Exiting");
                    return;
                }
                default ->System.out.println("Invalid");
            }
        }
    }
}
