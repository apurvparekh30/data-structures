class Solution {
    
    Map<String,List<String>> map = new HashMap<>();
    
    List<String> rec(String s,List<String> wordList){
        if(map.containsKey(s)){
            return map.get(s);
        }
        List<String> newList = new ArrayList<>();
        if(s.length()==0){
            newList.add("");
            return newList;
        }
        for(String word:wordList){
            if(s.startsWith(word)){
                List<String> temp = rec(s.substring(word.length()),wordList);
                for(String st:temp){
                    newList.add(word + (st.isEmpty() ? "" : " ") + st);
                }
            }
        }
        map.put(s,newList);
        return newList;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s.isEmpty() || wordDict.size()==0)
            return new ArrayList<>();
        Collections.sort(wordDict,Collections.reverseOrder());
        return rec(s,wordDict);
    }
}