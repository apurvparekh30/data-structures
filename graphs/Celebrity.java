import java.util.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			int M[][] = new int[N][N];
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					M[i][j] = sc.nextInt();
				}
			}
		System.out.println(new GfG().getId(M,N));
		t--;
		}
	}
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

class GfG
{
    // The task is to complete this function
    int getId(int M[][], int n)
    {
        // Your code here
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)
            st.push(i);

        int u = st.pop();
        int v = st.pop();

        int ans = -1;
        while(st.size()>=1){
            if(M[u][v]==1){
                u = st.pop();
            }
            else {
                v = st.pop();
            }
        }
        int c;
        if(M[u][v]==1){
            c = v;
        }
        else{
            c = u;
        }
        boolean flag = true;
        for(int i=0;i<n;i++){
            if(i==c)
                continue;
            if(M[c][i]==1 || M[i][c]==0){
                flag = false;
                break;
            }
        }
        if(flag)
            ans = c;
        return ans;
    }
}