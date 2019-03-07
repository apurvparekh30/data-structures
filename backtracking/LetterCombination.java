import java.util.*;

class Solution {
    boolean done[][];
    String []words = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> list = new ArrayList<String>();
    char[] nums;

    void rec(int p,String s){
        if(s.length() == nums.length){
            list.add(s);
            return;
        }
        int digit = nums[p]-'0';
        for(int i=0;i<words[digit].length();i++){
            if(done[p][i])
                continue;
            done[p][i] = true;
            rec(p+1,s+words[digit].charAt(i));
            done[p][i] = false;
        }
    }

    public List<String> letterCombinations(String digits) {
        nums = digits.toCharArray();
        done = new boolean[nums.length][];
        for(int i=0;i<nums.length;i++){
            done[i] = new boolean[words[nums[i]-'0'].length()];
        }
        if(nums.length>0)
            rec(0,"");
        return list;
    }
}