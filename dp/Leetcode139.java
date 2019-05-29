class Solution {
    
    Map<Character,List<String>> adj = new HashMap<>();
    Map<String,Boolean> can = new HashMap<>();
    
    boolean rec(String curr,int i,String s){
        if(curr.equals(s))
            return true;
        if(i > s.length()){
            return false;
        }
        if(!can.containsKey(curr)){
            boolean ans = false;
            List<String> words = adj.getOrDefault(s.charAt(i),new ArrayList<>());
            for(String word:words){
                String tmp = curr + word;
                if(tmp.length() > s.length())
                    continue;
                if(s.substring(0,tmp.length()).equals(tmp)) {
                    ans = ans | rec(tmp,tmp.length(),s);
                    if(ans)
                        break;
                }
            }
            can.put(curr,ans);
        }
        return can.get(curr);
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.isEmpty())
            return true;
        if(wordDict.isEmpty())
            return false;
        for(String word:wordDict){
            char c = word.charAt(0);
            if(!adj.containsKey(c)){
                adj.put(c,new ArrayList<>());
            }
            adj.get(c).add(word);
        }
        return rec("",0,s);
    }
}