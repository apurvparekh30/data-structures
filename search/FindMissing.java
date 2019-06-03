import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    static Scanner fs = new Scanner(System.in);

    static int binarySearch(int low ,int high,int []nums){
        if(low > high)
            return -1;
        if(low == high)
            return nums[low];
        int mid = low + (high - low) / 2;
        if(nums[mid] - mid == 2){
            return binarySearch(low,mid,nums);
        }
        return binarySearch(mid+1,high,nums); 
    }
    public static void main(String[] args) {
        // code
        int tc = fs.nextInt();
        while(tc-- > 0){
            int n = fs.nextInt();
            int []nums = new int[n-1];
            for(int i=0;i<n-1;i++)
                nums[i] = fs.nextInt();
            if(nums.length == 1){
                System.out.println(nums[0] == n ? n - 1 : n);
            }
            else {
                Arrays.sort(nums);
                int ans = binarySearch(0,nums.length-1,nums);
                System.out.println(ans - 1);
            }  
        }
    }
}