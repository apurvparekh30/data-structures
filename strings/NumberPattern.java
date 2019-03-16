import java.util.*;

class Solution {

    static char []input;
    static Scanner fs = new Scanner(System.in);
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            input = fs.next().toCharArray();
            StringBuilder sb = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            int curr = 1;
            sb.append(curr);
            for(int i=0;i<input.length;i++){
                char ch = input[i];
                curr++;
                if(ch=='D'){
                    temp.append(curr);
                }
                else {
                    String s = temp.reverse().toString();
                    sb.insert(sb.length()-1,s);
                    sb.append(curr);
                    temp = new StringBuilder();
                }
            }
            if(temp.length() > 0){
                String s = temp.reverse().toString();
                sb.insert(sb.length()-1,s);
            }
            System.out.println(sb);
        }
    }
}