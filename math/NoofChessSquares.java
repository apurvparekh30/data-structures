import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner fs = new Scanner(System.in);
        int tc = fs.nextInt();
        while(tc-- > 0){
            int n = fs.nextInt();
            System.out.println((n * (n+1) * (2*n+1))/6);
        }
    }
}