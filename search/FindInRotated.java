import java.io.*;
import java.util.*;

class Solution {
    static Scanner fs = new Scanner(System.in);
    static int n;
    static int []arr;
    static int key;

    static int binarySearch(int low,int high){
        //System.out.println(low + " "  + high);
        if(high - low <=2){
            if(arr[low]==key)
                return low;
            if(arr[low+1]==key)
                return low+1;
            if(arr[high]==key)
                return high;
            return -1;
        }
        int mid = low + (high-low)/2;
        //System.out.println(mid);
        if(arr[mid] == key)
            return mid;
        if((arr[mid-1] < arr[mid]) && (arr[mid] > arr[mid+1])){
            if(key >= arr[low] && key <= arr[mid-1])
                return binarySearch(low, mid-1);
            if(key >= arr[high] && key <= arr[mid+1])
                return binarySearch(mid+1, high);
        }
        /* if(arr[mid] < arr[mid+1]){
            if(key < arr[mid] && key  >= arr[low])
                return binarySearch(low, mid-1);
            if(key > arr[mid && key <= arr[high])
                return binarySearch(mid+1, high);
        } */
        if(arr[mid] < arr[mid+1]){
            if(key < arr[mid])
                return binarySearch(low,mid-1);
            else
                return binarySearch(mid+1, high);
        }
        if(key < arr[mid])
            return binarySearch(mid+1, high);
        else
            return binarySearch(low,mid-1);
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            //System.out.println(arr[16075] + " " + arr[16076] + " "+ arr[16077] + " " + arr[16078]);
            key = fs.nextInt();
            System.out.println(binarySearch(0,n-1));
        }
    }
}