import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}

class GfG {
    int binarySearch(int low,int high,int []arr){
        if(low >= high)
            return low;
        int mid = low + (high - low)/2;
        if(arr[mid] == 1)
            return binarySearch(low,mid-1,arr);
        return binarySearch(mid+1,high,arr);
    }
    int transitionPoint(int arr[], int n) {
        // Your code here
        int ans = binarySearch(0, n-1,arr);
        if(arr[ans]==0)
            ans++;
        return ans;
    }
}
