import java.util.*;
import java.io.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static String []numbers;

    static class StringCompare implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = o1.toString();
            String s2 = o2.toString();
            return Integer.compare(Integer.parseInt(s2+s1),Integer.parseInt(s1+s2));
        }
    }
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            numbers = new String[n];
            for(int i=0;i<n;i++)
                numbers[i] = fs.next();
            Arrays.sort(numbers,new StringCompare());
            StringBuilder sb = new StringBuilder();
            for(String num:numbers){
                sb.append(num);
            }
            System.out.println(sb);
        }
    }
}