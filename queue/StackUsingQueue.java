class MyStack {
    
    Queue<Integer> q; 
    Queue<Integer> aux;
    int top;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new ArrayDeque<>();
        aux = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q.size() > 1){
            int no = q.poll();
            top = no;
            aux.offer(no);
        }
        int ret = q.poll();
        q = aux; 
        aux = new ArrayDeque<>();
        return ret;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */