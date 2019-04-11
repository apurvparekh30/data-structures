import java.util.*;

class Solution {

    static Scanner fs  = new Scanner(System.in);
    static int n;
    static int []arr;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            int i=0;
            int j = n-1;
            int count = 0;
            while(i < j){
                if(arr[i]==arr[j]){
                    i++;
                    j--;
                }
                else if(arr[i] < arr[j]){
                    arr[i+1] += arr[i];
                    i++;
                    count++;
                }
                else {
                    arr[j-1] += arr[j];
                    j--;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}