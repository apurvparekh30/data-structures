import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int count = 0;
    static int n,m;

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
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            m = fs.nextInt();
            count=0;
            if(n==0)
                count++;
            for(int i=1;i<=9;i++){
                dfs(""+(char)(i+'0'));
            }
            System.out.println(count);
        }
    }
}