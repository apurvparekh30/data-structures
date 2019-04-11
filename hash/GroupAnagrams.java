import java.util.*;
import java.io.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static char[][] words;
    static Map<String,Integer> map;
    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            words = new char[n][];
            for(int i=0;i<n;i++)
                words[i] = fs.next().toCharArray();
            map = new HashMap<>();
            for(char []w:words){
                Arrays.sort(w);
                String s = new String(w);
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                    continue;
                }
                map.put(s,1);
            }
            List<Integer> list = new ArrayList<>();
            for(String key:map.keySet()){
                list.add(map.get(key));
            }
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for(int i:list){
                sb.append(i).append(' ');
            }
            System.out.println(sb);
        }
    }
}