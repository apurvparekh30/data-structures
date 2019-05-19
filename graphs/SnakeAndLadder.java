import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static Map<Integer,Integer> map;

    static class State {
        int u;
        int c;
        State(int u,int c){
            this.u = u;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            map = new HashMap<>();
            int n = fs.nextInt();
            for(int i=0;i<n;i++)
                map.put(fs.nextInt(),fs.nextInt());
            Queue<State> q = new ArrayDeque<>();
            q.offer(new State(1,0));
            boolean done[] = new boolean[31]; 
            done[1] = true;
            int ans = -1;
            while(!q.isEmpty()) {
                State curr = q.poll();
                if(curr.u!=30 && map.containsKey(curr.u)){
                    curr.u = map.get(curr.u);
                }
                if(curr.u == 30){
                    ans = curr.c;
                    break;
                }
                
                for(int dice = 1;dice<=6;dice++){
                    if(curr.u + dice > 30)
                        continue;
                    if(done[curr.u + dice])
                        continue;
                    done[curr.u + dice] = true;
                    q.offer(new State(curr.u + dice,curr.c + 1));
                }
            }
            System.out.println(ans);
        }
    }
}