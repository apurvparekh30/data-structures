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
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            int i = 0;
            while(i<n){
                if(stack.isEmpty() || arr[stack.peek()] < arr[i]){
                    stack.push(i);
                    i++;
                    continue;
                }
                
                int top = stack.pop();
                //System.out.println(top + " " + i + " " + (stack.isEmpty() ? "empty":stack.peek()));
                
                max = Math.max(max,(arr[top] * (stack.isEmpty() ? i:i-1-stack.peek())));
            }
            while(!stack.isEmpty()){
                int top = stack.pop();
                max = Math.max(max,(arr[top] * (stack.isEmpty() ? i:i-1-stack.peek())));
            }
            System.out.println(max);
        }
    }
}