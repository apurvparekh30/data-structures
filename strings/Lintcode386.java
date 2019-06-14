public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        
        int n = s.length();
        
        int i = 0;
        int j = 0;
        
        int []count = new int[200];
        
        int len = 0;
        int max = 0;
        while(i < n && j < n){
            char c = s.charAt(i);
            if(len < k || count[c] > 0){
                if(count[c] == 0){
                    len++;
                }
                count[c]++;
                //System.out.println(i + " " + c + " " + count[c] + " " + len + " " + j);
                i++;
                continue;
            }
            c = s.charAt(j);
            max = Math.max(max,i - j);
            j++;
            count[c]--;
            if(count[c]==0){
                len--;
            }
        }
        max = Math.max(max,i - j);
        return max;
    }
}