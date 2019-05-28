class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        if(n == 0)
            return true;
        int []in = new int[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int []r:prerequisites){
            int u = r[0]; int v = r[1];
            if(!map.containsKey(v))
                map.put(v,new ArrayList<>());
            in[u]++;
            map.get(v).add(u);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.offer(i);
                count++;
            }
        }
        if(count == 0)
            return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int v:map.getOrDefault(curr,new ArrayList<>())){
                in[v]--;
                if(in[v]==0){
                    q.offer(v);
                    count++;
                }
            }
        }
        return count == n;
    }
}