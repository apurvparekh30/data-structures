import java.util.*;
import java.math.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            GfG g=new GfG();
            System.out.println(g.multiply(a,b));
        }
    }
}


class GfG{
    int carry = 0;

    char mult(char a,char b){
        int i = a - '0';
        int j = b - '0';
        int m = i * j;
        m = m + carry;
        carry = m / 10;
        m = m % 10;
        return (char) (m+'0');
    }
    char add(char a,char b){
        int i = a - '0';
        int j = b - '0';
        int m = i + j;
        carry = carry + (m/10);
        m = m % 10;
        return (char)(m+'0');
    }

    public String multiply(String a,String b){
        int mm = 1;
        char []m,n;
        if(a.charAt(0)=='-'){
            mm = mm * -1;
            m = a.substring(1).toCharArray();
        }
        else {
            m = a.toCharArray();
        }
            
        if(b.charAt(0)=='-'){
            mm = mm * -1;
            n = b.substring(1).toCharArray();
        }
        else {
            n = b.toCharArray();
        }
        char []c = new char[m.length+n.length];

        Arrays.fill(c,'0');
        int kk = m.length+n.length-1;
        for(int i=m.length-1;i>=0;i--,kk--){
            int k = kk;
            for(int j=n.length-1;j>=0;j--,k--){
                c[k] = add(c[k],mult(m[i],n[j]));  
            }
            c[k] = (char)(carry + '0');
            carry = 0;
        }
        int from = 0;
        while(c[from]=='0'){
            from++;
        }
        String ret =  new String(c).substring(from);
        if(mm == -1)
            ret = "-" + ret;
        return ret;
    }
}