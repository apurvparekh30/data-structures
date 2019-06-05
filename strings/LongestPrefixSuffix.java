import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static char []text;
    public static void main(String[] args) {
        // code
        int tc = fs.nextInt();

        while(tc-- > 0){
            text = fs.next().toCharArray();
            int n = text.length;
            int []lps = new int[n];
            int i = 1;
            int len = 0;    // represents length of prefix
            int max = 0;
            while(i < n){
                System.out.println(i);
                if(text[i] == text[len]){
                    len++;
                    lps[i] = len;
                    i++;
                    continue;
                }
                if(len != 0){
                    len = lps[len-1];    
                    /// why lps[len-1] instead of len--;
                    /* 
                        We know that i-1 has prefix of length len - 1
                        so we try to find occurent of (i - len - 1) to i - 1 chracters 
                        with the help of prefix. And we continue finding the prefix with hope
                        that occurance next character would be i'th character

                        example // abcabdabcabc   at i = 11
                     */
                }
                else {
                    lps[i] = len;
                    i++;
                }
            }
            System.out.println(max);
        }
    }
}