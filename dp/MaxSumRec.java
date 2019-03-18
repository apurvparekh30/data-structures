import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int [][]arr;
    static int r,c;


    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            r = fs.nextInt();
            c = fs.nextInt();

            arr = new int[r][c];

            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    arr[i][j] = fs.nextInt();
                    if(i>0)
                        arr[i][j] += arr[i-1][j];
                    if(j>0)
                        arr[i][j] += arr[i][j-1];
                    if(i>0 && j>0)
                        arr[i][j] -= arr[i-1][j-1];
                }
            }
            int maxSum = Integer.MIN_VALUE;
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                    for(int k=i;k<r;k++)
                        for(int l=j;l<c;l++){
                            int sum = arr[k][l];
                            if(i>0) 
                                sum -= arr[i-1][l];
                            if(j>0)
                                sum -= arr[k][j-1];
                            if(i>0 && j>0)
                                sum += arr[i-1][j-1];
                            if(maxSum < sum){
                                maxSum = sum;
                            } 
                        }



            System.out.println(maxSum);
        }
    }
}