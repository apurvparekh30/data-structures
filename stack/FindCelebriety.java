import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new GfG().getId(M, N));
            t--;
        }
    }
}

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

class GfG {
    // The task is to complete this function
    int getId(int M[][], int n) {
        // Your code here
        Stack<Integer> st = new Stack<>();
        st.push(0);
        st.push(1);
        int c = 2;
        while(st.size() >= 2 && c<=n ){
            int a = st.pop();
            int b = st.pop();
            if(M[a][b]==1){
                st.push(b);
            }
            else {
                st.push(a);
            }
            if(c < n)
                st.push(c++);
        }
        
        int celebrity = st.pop();
        for(int i=0;i<n;i++){
            if(i==celebrity)
                continue;
            if(M[i][celebrity]==0){
                celebrity=-1;
                break;
            }
        }
        return celebrity;
    }
}