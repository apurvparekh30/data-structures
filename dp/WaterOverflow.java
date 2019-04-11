import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int r,c;
    static int k;
    static double pascal[][];
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            k = fs.nextInt();
            r = fs.nextInt();
            c = fs.nextInt();
            pascal = new double[r+1][r+1];
            pascal[0][0] = k * 1.0;
            
            for(int i=0;i<r;i++){
                for(int j=0;j<r;j++){
                    double p = pascal[i][j];
                    //System.out.println(p);
                    if(Double.compare(p,1.0) > 0){
                        p = p - 1;
                        pascal[i][j] = 1;
                        pascal[i+1][j] += p/2.0;
                        pascal[i+1][j+1] += p/2.0; 
                    }
                }
            }
            /* for(int i=0;i<r;i++){
                System.out.println(Arrays.toString(pascal[i]));
            } */
            System.out.printf("%.6f\n",pascal[r-1][c-1]);
        }
    }
}