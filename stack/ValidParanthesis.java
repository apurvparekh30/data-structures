import java.util.*;
import java.io.*;

class Solution {
    static Scanner fs = new Scanner(System.in);
    static Stack<Integer> st;
    static char []string;

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            string = fs.next().toCharArray();
            st = new Stack<>();
            st.push(-1);
            int max = 0;
            for(int i=0;i<string.length;i++){
                char c = string[i];
                if(c=='('){
                    st.push(i);
                }
                else{
                    st.pop();
                    if(!st.isEmpty()){
                        if(max < i - st.peek()){
                            max = i - st.peek();
                        }
                    }
                    else {
                        st.push(i);
                    }
                }
            }
            System.out.println(max);
        }
    }

}