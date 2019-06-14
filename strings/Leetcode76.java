class Solution {
    
    boolean match(int []tar,int []curr) {
        for(int i=0;i<200;i++){
            if(tar[i] > curr[i])
                return false;
        }
        return true;
    }
    
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
            return "";
        if(t.equals(s))
            return t;
        int []tar,curr;
        tar = new int[200];
        curr = new int[200];
        int st = -1,en = -1;
        int max = 987654321;
        for(char c:t.toCharArray()){
            tar[c]++;
        }
        int i = 0;
        int j = 0;
        int n = s.length();
        while(i < n || j < n){
            if(i < n && !match(tar,curr)){
                curr[s.charAt(i)]++;
                i++;
            }
            else {
                if(match(tar,curr) && max > i - j){
                    max = i - j;
                    st = j;
                    en = i;
                }
                curr[s.charAt(j)]--;
                j++;
                
            }
        }
        if(st==-1 || en==-1)
            return "";
        return s.substring(st,st+(en-st));
    }
}