class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        int []in = new int[numCourses];
        
        for(int []pair:prerequisites){
            int u = pair[0]; int v = pair[1];
            if(!adj.containsKey(v))
                adj.put(v,new ArrayList<>());
            adj.get(v).add(u);
            in[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        
        int []order = new int[numCourses];
        int i = 0;
        for(i=0;i<numCourses;i++){
            if(in[i]==0){
                q.offer(i);
            }
        }
        System.out.println(q);
        if(q.isEmpty())
            return new int[0];
        i = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            order[i++] = curr;
            for(int next:adj.getOrDefault(curr,new ArrayList<>())){
                in[next]--;
                if(in[next]==0)
                    q.offer(next);
            }
        }
        
        return (i == numCourses ? order : new int[0]);
    }
}