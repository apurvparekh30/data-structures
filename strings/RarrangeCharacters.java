import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static char []string;
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            string = fs.next().toCharArray();
            Map<Character,Integer> map = new HashMap<>();
            for(char c:string){
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }
                else {
                    map.put(c,1);
                }
            }
            List<Integer> list = new ArrayList<>();
            for(char c:map.keySet()){
                list.add(map.get(c));
            }
            Collections.sort(list);
            int sum = 0;
            int max = 0;
            for(int f:list){
                sum += f;
                max = Math.max(max,f);
            }
            StringBuilder sb = new StringBuilder("1");
            int cmp = sum - max;
            cmp = Math.max(cmp,(int) (Math.ceil(string.length/2.0)));
            //System.out.println("cmp = " + cmp);
            if(max > cmp){
                sb = new StringBuilder("0");
            }
            System.out.println(sb);
        }
    }
}