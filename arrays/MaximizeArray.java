import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static int [] a,b;
    static TreeSet<Integer> set;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            a = new int[n];
            b = new int[n];
            set = new TreeSet<>(Comparator.reverseOrder());
            for(int i=0;i<n;i++){
                int no = fs.nextInt();
                a[i] = no;
                set.add(no);
            }
            for(int i=0;i<n;i++){
                int no = fs.nextInt();
                b[i] = no;
                set.add(no);
            }
            while(set.size() > n){
                set.pollLast();
            }
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for(int bb:b){
                if(count >= n)
                    break;
                if(set.contains(bb)){
                    count++;
                    set.remove(bb);
                    sb.append(bb).append(' ');
                }
            }
            for(int aa:a){
                if(count>=n)
                    break;
                if(set.contains(aa)){
                    count++;
                    set.remove(aa);
                    sb.append(aa).append(' ');
                }
            }
            System.out.println(sb);
        }
    }
}