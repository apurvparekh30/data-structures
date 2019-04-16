import java.util.*;


class TestClass {

    static Scanner fs = new Scanner(System.in);
    static Map<Integer,List<Integer>> adj;
    static boolean done[];
    static int n;

    static class pair {
        int d,u;
        pair(int u,int d){
            this.u = u;
            this.d = d;
        }
        @Override
        public String toString() {
            return u + "  " + d;
        }
    }


    static pair dfs(int u){
        int ans = 0;
        int src = u;
        if(!adj.containsKey(u)){
            return new pair(1,u);
        }
        for(int v:adj.get(u)) {
            if(done[v]) 
                continue;
            done[v] = true;
            pair tmp = dfs(v);
            if(ans < tmp.d){
                ans = tmp.d;
                src = tmp.u;
            }
        }
        return new pair(1+ans,src);
    }

    static int bfs(int u){
        Queue<pair> q = new ArrayDeque<>();
        boolean done[] = new boolean[n+1];
        done[u] = true;
        int d = 0;
        q.offer(new pair(u,d));
        int dist = 0;
        int vertex = u;

        while(!q.isEmpty()){
            pair curr = q.poll();
            u = curr.u;
            d = curr.d;
            if(dist < d){
                dist = d;
                vertex = u;
            }
            for(int v:adj.getOrDefault(u, new ArrayList<>())){
                if(done[v])
                    continue;
                done[v] = true;
                q.offer(new pair(v,d+1));
            }
        }
        return vertex;
    }
    public static void main(String args[]) throws Exception {
        n = fs.nextInt();
        adj = new HashMap<>();
        for(int i=0;i<n-1;i++){
            int u = fs.nextInt();
            int v = fs.nextInt();
            if(!adj.containsKey(u)){
                adj.put(u,new ArrayList<>());
            }
            adj.get(u).add(v);
            if(!adj.containsKey(v)) {
                adj.put(v,new ArrayList<>());
            }
            adj.get(v).add(u);
        }
        int u = bfs(1);
        int v = bfs(u);
        System.out.println(u + "  "+ v);
    }
}