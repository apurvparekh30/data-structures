class Solution {
public:
    
    void qsort(int l,int r,vector<int>& num,int k){
        if(l < r){
            int loc = partition(l,r,num);
            if(loc == k-1)
                return;
            qsort(l,loc-1,num,k);
            qsort(loc+1,r,num,k);
        }
    }
    
    int partition(int l,int r,vector<int>& num){
        int pivot = num[r];
        int j = l;
        for(int i=l;i<r;i++){
            if(num[i] >= pivot){
                swap(num[i],num[j]);
                j++;
            }
        }
        swap(num[j],num[r]);
        return j;
    }
    
    int findKthLargest(vector<int>& nums, int k) {
        qsort(0,nums.size()-1,nums,k);
        return nums[k-1];
    }
};
