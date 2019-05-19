import java.util.*;

class Solution {
    static String s;
    static Scanner fs = new Scanner(System.in);

    static String add(String s1,String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >=0 || j>=0){
            int a = (i < 0) ? 0 : s1.charAt(i) - '0';
            int b = (j < 0) ? 0 : s2.charAt(j) - '0';

            int res = a + b + carry;
            carry = res / 10;
            res = res % 10;
            sb.append(res);
            i--;
            j--;
        }
        if(carry > 0)
            sb.append(carry);
        return new String(sb.reverse());
    }

    static boolean rec(int beg,int len1,int len2){
        String s1 = s.substring(beg,beg+len1);
        String s2 = s.substring(beg+len1,beg+len1+len2);
        //System.out.println(s1 + " Hello " + s2);
        String s3 = add(s1,s2);

        int s3len = s3.length();
        if(s3len > s.length() - len2 - len1 - beg){
            return false;
        }
        if(s3.equals(s.substring(beg+len1+len2,beg+len1+len2+s3len))){
            if(beg+len1+len2+s3len == s.length())
                return true;
            return rec(beg+len1,len2,s3len);
        }
        return false;
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            s = fs.next();
            int n = s.length();
            int res = 0;
            for(int i=1;i<n;i++){
                for(int j=1;i + j < n;j++){
                    if(rec(0,i,j)){
                        res = 1;
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }
}