class Solution {
    
    boolean equals(int []a,int []b){
        for(int i=0;i<26;i++)
            if(a[i]!=b[i])
                return false;
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        int n = s.length();
        if(n==0)
            return ret;
        int m = p.length();
        int []pcount = new int[26];
        int want = 0;
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            pcount[c-'a']++;
            want ++;
        }
        
        int start = 0;
        int end = 0;
        while(end < n){
            char c = s.charAt(end);
            if(pcount[c-'a'] > 0)
                want--;
            pcount[c-'a']--;
            end++;
            if(end - start == m){
                if(want==0)
                    ret.add(start);
                c = s.charAt(start);
                pcount[c-'a']++;
                if(pcount[c-'a'] > 0)
                    want++;
                start++;
            }
        }
        return ret;
    }
}