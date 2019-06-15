public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        // Write your code here
        int n = words.length;
        if(n==0)
            return "";
        Map<Character,List<Character>> adj = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int []in = new int[26];
        for(String word: words){
            for(char c:word.toCharArray()) {
                set.add(c);
            }
        }
        for(int i=0;i<n-1;i++){
            String s = words[i];
            String t = words[i+1];
            int x = 0;
            int y = 0;
            while(x < s.length() || y < t.length()) {

                if(s.charAt(x) == t.charAt(y)) {
                    x++;
                    y++;
                }
                else {
                    if(!adj.containsKey(s.charAt(x))) {
                        adj.put(s.charAt(x),new ArrayList<>());
                    }
                    adj.get(s.charAt(x)).add(t.charAt(y));
                    in[t.charAt(y) - 'a']++;
                    break;
                }
            }
        }
        String ans = "";
        Queue<Character> q = new PriorityQueue<>();
        for(int i=0;i<26;i++) {
            if(in[i]==0 && set.contains((char)(i + 'a'))) {
                q.offer((char)(i + 'a'));
            }
        }
        while(!q.isEmpty()) {
            char curr = q.poll();
            ans = ans + curr;
            for(char next:adj.getOrDefault(curr,new ArrayList<>())) {
                in[next-'a']--;
                if(in[next-'a']==0) {
                    q.offer(next);
                }
            }
        }
        if(ans.length()!= set.size()) {
            return "";
        }
        return ans;
    }
}