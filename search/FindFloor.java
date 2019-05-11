import java.util.*;
import java.lang.*;
import java.io.*;

class Solution  {

    static Scanner fs = new Scanner(System.in);

    static int rec(int low,int high,long []nums,long target){
        //System.out.println(nums[low] + " " + target);
        if(target < nums[low])
            return -1;
        if(target > nums[high])
            return high;
        if(low==high)
            return low;
        int mid = low + (high-low)/2;
        if(target >= nums[mid] && target <= nums[mid+1])
            return (nums[mid+1]==target) ? mid+1 : mid;
        if(target < nums[mid])
            return rec(low,mid-1,nums,target);
        return rec(mid+1,high,nums,target);
    }

    public static void main(String[] args) {
        // code
        int tc = fs.nextInt();
        while(tc-- > 0){
            int n = fs.nextInt();
            long target = fs.nextLong();
            long nums[] = new long[n];
            for(int i=0;i<n;i++){
                nums[i] = fs.nextLong();
            }
           // System.out.println(Arrays.toString(nums));
            
            System.out.println(rec(0,nums.length-1,nums,target));
        }
    }
}