class Solution {
    
    class Pair implements Comparable<Pair> {
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair that){
            return this.x - that.x;
        }
        @Override
        public String toString() {
            return x + " " + y;
        }
    } 
    
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==0)
            return new int[0][0];
        List<Pair> list = new ArrayList<>();
        for(int []r:intervals){
            list.add(new Pair(r[0],r[1]));
        }
        List<Pair> ans = new ArrayList<>();
        Collections.sort(list);
        //System.out.println(list);
        Pair p = list.get(0);
        for(int i=1;i<list.size();i++){
            Pair curr = list.get(i);
            if(p.y >= curr.x){
                p.y = Math.max(p.y,curr.y);
                p.x = Math.min(p.x,curr.x);
            }
            else {
                ans.add(p);
                p = curr;
            }
        }
        ans.add(p);
        int [][]ret = new int[ans.size()][2];
        int i = 0;
        for(Pair pp:ans){
            ret[i][0] = pp.x;
            ret[i][1] = pp.y;
            i++;
        }
        return ret;
    }
}