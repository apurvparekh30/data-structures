import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        // code
        Scanner fs = new Scanner(System.in);
        int cases = fs.nextInt();
        for(int tt=1;tt<=cases;tt++){
            System.out.println(Integer.bitCount(fs.nextInt() ^ fs.nextInt()));
        }
    }
}