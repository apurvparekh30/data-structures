import java.util.Comparator;

class Solution {
    
    class NumberCompare implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return ((o1+o2).compareTo(o2+o1));
        }
    }
    
    public String largestNumber(int[] nums) {
        if(nums.length==0)
            return "";
        String []numbers = new String[nums.length];
        for(int i=0;i<nums.length;i++)
            numbers[i] = String.valueOf(nums[i]);
        Arrays.sort(numbers,new NumberCompare());
        StringBuilder sb = new StringBuilder();
        int n = numbers.length-1;
        if(numbers[n].equals("0"))
            return "0";
        for(int i=n;i>=0;i--){
            sb.append(numbers[i]);
        }
        return sb.toString();
    }
}