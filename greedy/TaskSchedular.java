class Solution {
    public int leastInterval(char[] tasks, int n) {
        int []count = new int[26];
        for(char c:tasks){
            count[c-'A']++;
        }
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++)
            if(count[i] > 0)
                q.add(count[i]);
        int time = 0;
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int i = 0;
            while(i <= n){
                if(!q.isEmpty()){
                    if(q.peek() > 1) {
                        temp.add(q.poll()-1);
                    }
                    else {
                        q.poll();
                    } 
                }
                time++;
                if(q.isEmpty() && temp.isEmpty())
                    break;
                i++;
            }
            q.addAll(temp);
        }
        return time;
    }
}