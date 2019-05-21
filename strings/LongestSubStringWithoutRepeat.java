class Solution {
    Map<Character,Integer> map = new HashMap<>();
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0)
            return n;
        int i=0,j=0;
        int max = 0;
        while(j < n){
            //System.out.println(map);
            if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) >= i){
                max = Math.max(max,j-i);
                i = map.get(s.charAt(j))+1;
            }
            map.put(s.charAt(j),j);
            j++;
        }
        max = Math.max(max,j-i);
        return max;
    }
}