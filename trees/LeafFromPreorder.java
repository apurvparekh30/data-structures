import java.util.*;
import java.io.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static int []arr;
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = fs.nextInt();
            }
            StringBuilder sb = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            stack.push(arr[0]);
            for(int i=1;i<n;i++){
                int curr = arr[i];
                if(stack.peek() > curr){
                    stack.push(curr);
                    continue;
                }
                int top = stack.pop();
                if(!stack.isEmpty() && stack.peek() < curr)
                    sb.append(top).append(' ');
                while(!stack.isEmpty() && stack.peek() < curr){
                    stack.pop();
                }
                stack.push(curr);
            }
            sb.append(stack.pop()).append(' ');
            System.out.println(sb);
        }
    }
}