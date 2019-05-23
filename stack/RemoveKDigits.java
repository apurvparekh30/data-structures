class Solution {
    
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < num.length()){
            if(stack.isEmpty() || stack.peek() <= num.charAt(i) || k <= 0){
                stack.push(num.charAt(i));
                i++;
                continue;
            }
            stack.pop();
            k--;
        }
        while(k-- > 0){
            stack.pop();
        }
        //System.out.println(stack);
        if(stack.isEmpty())
            return "0";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        sb.reverse();
        i = 0;
        while(i < sb.length() && sb.charAt(i)=='0')
            i++;
        sb.delete(0,i);
        if(sb.length() == 0)
            sb.append('0');
        return sb.toString();
    }
}