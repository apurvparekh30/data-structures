// Solution to count substrings starting and ending with 1

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        // code
        Scanner fs = new Scanner(System.in);
        int cases = fs.nextInt();
        for(int tt=0; tt<cases;tt++){
            char []s = fs.next().toCharArray();
            int oneCount = 0;
            for(char c:s){
                if(c=='1')
                    oneCount++;
            }
            System.out.println((oneCount * (oneCount-1))/2);
        }
    }
}