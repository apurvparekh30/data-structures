class Solution {
    class Pair implements Comparable<Pair>{
        int num;
        int freq;
        Pair(int num,int freq){
            this.num = num;
            this.freq = freq;
        }
        @Override
        public int compareTo(Pair other){
            return this.freq - other.freq;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Queue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int key:map.keySet()){
            pq.offer(new Pair(key,map.get(key)));
        }
        while(k-- > 0){
            ans.add(pq.poll().num);
        }
        return ans;
    }
}