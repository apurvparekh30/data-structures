
class Solution {
    Stack<Character> op = new Stack<>();
    Stack<Integer> values = new Stack<>();

    int apply(int a,int b,char op){
        if(op=='+')
            return a+b;
        return a-b;
    }

    public int calculate(String s) {
        char []expr = s.toCharArray();
        for(int i=0;i<expr.length;){
            if(expr[i]==' '){
                i++;
            }
            else if(expr[i]=='('){
                op.push(expr[i]);
                i++;
            }
            else if(expr[i]==')'){
                while(!op.isEmpty() || op.peek()!='('){
                    int val1 = values.pop();
                    int val2 = values.pop();
                    char opr = op.pop();
                    int tmp = apply(val2,val1,opr);
                    values.push(tmp);
                }
                op.pop();
                i++;
            }
            else if(Character.isDigit(expr[i])){
                int num = 0;
                while(i<expr.length && Character.isDigit(expr[i])){
                    num = (num*10) + (expr[i]-'0');
                    i++;
                }
                values.push(num);
            }
            else {
                if(!op.isEmpty() && op.peek()!='('){
                    int val1 = values.pop();
                    int val2 = values.pop();
                    char opr = op.pop();
                    int tmp = apply(val2,val1,opr);
                    values.push(tmp);
                }
                op.push(expr[i]);
                i++;
            }
        }
        while(!op.isEmpty()) {
            int val1 = values.pop();
            int val2 = values.pop();
            char opr = op.pop();
            int tmp = apply(val2,val1,opr);
            values.push(tmp);
        }
        return values.peek();
    }
}