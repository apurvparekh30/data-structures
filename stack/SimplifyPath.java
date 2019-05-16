class Solution {
    public String simplifyPath(String path) {
        if(path.isEmpty())
            return null;
        String []tokens = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String token:tokens){
            if(token.isEmpty())
                continue;
            if(token.equals("..")){
                if(!stack.isEmpty())
                    stack.removeLast();
            }
            else if(token.equals(".")){
                
            }
            else {
                stack.addLast(token);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/").append(stack.pollFirst());
        }
        if(sb.length()==0)
            sb.append("/");
        return sb.toString();
    }
}