class Solution {
    
    int precedance(char c){
        if(c=='+' || c=='-')
            return 1;
        return 2;
    }
    
    int apply(int a,int b,char op){
        if(op=='+')
            return b + a;
        if(op=='-')
            return b - a;
        if(op=='*')
            return b * a;
        return b / a;
    }
    
    public int calculate(String s) {
        Stack<Integer> values;
        Stack<Character> op;
        values = new Stack<>();
        op = new Stack<>();
        
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c==' '){
                i++;
                continue;
            }
            if(Character.isDigit(c)){
                int no = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    no = no * 10 + (s.charAt(i) - '0');
                    i++;
                }
                values.add(no);
            }
            else {
                while(!op.isEmpty() && precedance(op.peek()) >= precedance(c)){
                    int val1 = values.pop();
                    int val2 = values.pop();
                    char opr = op.pop();
                    int res = apply(val1,val2,opr);
                    values.push(res);
                }
                op.push(c);
                i++;
            }
        }
        while(!op.isEmpty()){
            int val1 = values.pop();
            int val2 = values.pop();
            char opr = op.pop();
            int res = apply(val1,val2,opr);
            values.push(res);
        }
        return values.peek();
    }
}