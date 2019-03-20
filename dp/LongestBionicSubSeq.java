import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int []arr;
    static int []inc,dec;
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            int n = fs.nextInt();
            arr = new int[n];
            inc = new int[n];
            dec = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            inc[0] = 1;
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if(arr[j] < arr[i]){
                        inc[i] = Math.max(inc[i],inc[j]);
                    }
                }
                inc[i]++;
            }
            dec[n-1] = 0;
            for(int i=n-1;i>=0;i--){
                for(int j=n-1;j>i;j--){
                    if(arr[j] < arr[i]){
                        dec[i] = Math.max(dec[i],dec[j]);
                    }
                }
                dec[i]++;
            }
            int max = 0;
            for(int i=0;i<n;i++){
                max = Math.max(max,inc[i]+dec[i]-1);
            }
            System.out.println(max);
        }
    }
}