class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n==0 || n < k)
            return new int[0];
        int []ans = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int j = 0;
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst() < i - (k - 1))
                dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();

            dq.addLast(i);
            if(i >= (k-1)) {
                ans[j++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}