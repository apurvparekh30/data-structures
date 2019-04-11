import java.util.*;
import java.io.*;

class Solution {
    static Scanner fs = new Scanner(System.in);
    static long [][]pascal;
    static int n;
    static int []arr;

    static void generate(){
        int n = 1000001;
        pascal = new long[n][4];
        for(int i=0;i<n;i++){
            pascal[i][0] = 1;
        }
        for(int i=1;i<n;i++){
            int m = Math.min(i+1,4);
            for(int j=1;j<m;j++){
                pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
            }
        }
        /* for(int i=0;i<5;i++){
            System.out.println(Arrays.toString(pascal[i]));
        } */
    }

    public static void main(String[] args) {
        int tc =fs.nextInt();
        generate();
        while(tc-- > 0){
            n = fs.nextInt();
            int []count = new int[3];
            for(int i=0;i<n;i++){
                int no = fs.nextInt();
                count[no%3]++;
            }
            long cnt = 0;
            cnt = cnt + pascal[count[0]][2];
            cnt = cnt + pascal[count[0]][3];
            cnt = cnt + pascal[count[1]][3];
            cnt = cnt + pascal[count[2]][3];
            cnt = cnt + pascal[count[1]][1] * pascal[count[2]][1];
            cnt = cnt + pascal[count[0]][1] * pascal[count[1]][1] * pascal[count[2]][1];
            System.out.println(cnt);
        }
    }
}