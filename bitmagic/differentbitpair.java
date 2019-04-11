import java.util.*;
import java.io.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static int arr[];
    static final int mod = 1000000007;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            int sum = 0;
            for(int i=0;i<32;i++){
                int count = 0;
                for(int j=0;j<n;j++){
                    if((arr[j] & (1<<i)) == 0){
                        count++;
                    }
                }
                sum = (sum + (count * (n-count))%mod)%mod;
            }
            System.out.println((sum*2)%mod);
        }
    }
}