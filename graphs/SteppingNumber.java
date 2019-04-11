import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int count = 0;
    static int n,m;

    // string approach
    static void dfs(String number){
        int num = Integer.parseInt(number);
        //System.out.println(num);
        if(num > m)
            return;
        if(num >= n){
            count++;
        } 
        int last = number.charAt(number.length()-1)-'0';
        if(last+1 <= 9)
            dfs(number + (char)(last + 1 + '0'));
        if(last-1 >= 0)
            dfs(number + (char)(last - 1 + '0'));
    }

    // integer approach
    static void rec(int num){
        if(num > m)
            return;
        if(num >= n)
            count++;
        int last = num % 10;
        if(last + 1 <= 9)
            rec(num*10+last+1);
        if(last - 1 >= 0)
            rec(num*10+last-1);
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            m = fs.nextInt();
            count=0;
            if(n==0)
                count++;
            for(int i=1;i<=9;i++){
                rec(i);
            }
            System.out.println(count);
        }
    }
}