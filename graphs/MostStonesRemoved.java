class Solution {
    
    class pair {
        int i,j;
        pair(int i,int j){
            this.i = i;
            this.j = j;
        }
        @Override 
        public String toString(){
            return i + " " + j;
        }
    }
    
    Map<String,List<pair>> map = new HashMap<>();
    Set<String> seen = new HashSet<>();
    
    
    public void dfs(String u){
        for(pair v:map.get(u)){
            if(seen.contains(v.toString()))
                continue;
            seen.add(v.toString());
            dfs(v.toString());
        }
    }
    
    public int removeStones(int[][] stones) {
        int n = stones.length;
        for(int i=0;i<n;i++){
            pair u = new pair(stones[i][0],stones[i][1]); 
            map.put(u.toString(),new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    pair u = new pair(stones[i][0],stones[i][1]);
                    pair v = new pair(stones[j][0],stones[j][1]);
                    map.get(u.toString()).add(v);
                    map.get(v.toString()).add(u);
                }
            }
        }
        //System.out.println(map);
        int count = 0;
        for(String key:map.keySet()){
            if(!seen.contains(key)){
                count++;
                seen.add(key);
                dfs(key);
            }
        }
        return n - count;
    }
}