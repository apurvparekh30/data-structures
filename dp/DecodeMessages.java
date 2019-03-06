import java.util.*;
import java.io.*;

class Solution {
    static Scanner fs = new Scanner(System.in);
    static int n;
    static String string;
    static int dp[];

    static int rec(int i){
        //System.out.println("hello");
        if(i >= string.length())
            return 1;
        if(dp[i]!=-1)
            return dp[i];
        dp[i] = 0;
        int ans = 0;
        for(int size=1;size<=2;size++){
            if(i+size > string.length())
                break;
            String number = string.substring(i,i+size);
            int no = Integer.parseInt(number);
            if(no <= 26 && no > 0){

                ans=ans+rec(i+size);
            }
            if(no==0)
                break;
        }
        return dp[i] = ans;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            string = fs.next();
            boolean flag = true;
            if(string.charAt(0)=='0'){
                System.out.println(0);
                continue;
            }
                
            for(int i=1;i<string.length();i++){
                if(string.charAt(i)=='0' && (string.charAt(i-1)=='0' || string.charAt(i-1)>'2')){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                System.out.println(0);
                continue;
            }
            dp = new int[n];
            Arrays.fill(dp,-1);
            System.out.println(rec(0));
            //System.out.println(Arrays.toString(dp));
        }
    }
}