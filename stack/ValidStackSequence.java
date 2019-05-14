class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        int n = pushed.length;
        int m = popped.length;
        
        Stack<Integer> st = new Stack<>();
        
        while(i < n && j < m){
            if(st.isEmpty() || st.peek()!=popped[j]){
                st.push(pushed[i]);
                i++;
            }
            else if(st.peek()==popped[j]){
                st.pop();
                j++;
            }
        }
        while(!st.isEmpty()){
            if(st.peek()!=popped[j]){
                return false;
            }
            st.pop();
            j++;
        }
        return true;
    }
}