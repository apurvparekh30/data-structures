import java.util.*;
import java.io.*;

class Solution {
    static Scanner fs = new Scanner(System.in);
    static int [][]mat;
    static int n,m;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            m = fs.nextInt();
            mat = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    mat[i][j] = fs.nextInt();
                    if(i > 0)
                        mat[i][j] += mat[i-1][j];
                    if(j > 0)
                        mat[i][j] += mat[i][j-1];
                    if(i>0 && j>0)
                        mat[i][j] -= mat[i-1][j-1];
                }
            }
            
            int ans = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    for(int k=0;;k++){
                        int idx = i + k;
                        int jdx = j + k;
                        if(idx >= n || jdx >=m)
                            break;
                        int sum = mat[idx][jdx];
                        if(i > 0)
                            sum-= mat[i-1][jdx];
                        if(j > 0)
                            sum-= mat[idx][j-1];
                        if(i > 0 && j > 0)
                            sum+= mat[i-1][j-1];
                        int row = k+1;
                        if(sum == (row*row)){
                            //if(k==4)
                            //    System.out.println(i+" " + j + " " + idx + " " + jdx + " " + sum);
                            //System.out.println(sum + " " + k);
                            ans = Math.max(ans,row);
                        }
                            
                    }
                }
            }
            System.out.println(ans);
        }
    }
}