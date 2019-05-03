class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
           List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        int []in = new int[n];
        for(int i=0;i<n-1;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            in[u]++;
            in[v]++;
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(in[i]==1){
                leaves.add(i);
            }
        }
        while(n > 2){
            n = n - leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leave:leaves){
                for(int v:adj.get(leave)){
                    in[v]--;
                    if(in[v]==1){
                        newLeaves.add(v);
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}