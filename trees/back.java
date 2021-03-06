import java.util.*;


class TestClass {

    static Scanner fs = new Scanner(System.in);
    static Map<Integer,List<Integer>> adj;
    static boolean done[];

    static class pair {
        int d,u;
        pair(int d,int u){
            this.d = d;
            this.u = u;
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
        boolean done[]
    }
    public static void main(String args[]) throws Exception {
        int n = fs.nextInt();
        adj = new HashMap<>();
        done = new boolean [n+1]; 
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
        done[1] = true;
        int u = dfs(1).u;
        done = new boolean[n+1];
        done[u] = true;
        int v = dfs(u).u;
        System.out.println(u + "  "+ v);
    }
}