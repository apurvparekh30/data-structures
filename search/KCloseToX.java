class Solution {
    int rec(int low,int high,int []arr,int x){
        if(low==high)
            return low;
        if(x < arr[low])
            return low;
        if(x > arr[high])
            return high;
        int mid = low + (high - low) / 2;
        if(x >= arr[mid] && x <= arr[mid+1]){
            return (Math.abs(x-arr[mid]) <= Math.abs(x-arr[mid+1]) ? mid : mid+1);
        }
        if(x < arr[mid]){
            return rec(low,mid-1,arr,x);
        }
        return rec(mid+1,high,arr,x);
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = rec(0,arr.length-1,arr,x);
        List<Integer> list = new LinkedList();
        int left = i;
        int right = i + 1;
        while(k-- > 0){
            if(left < 0 && right < arr.length){
                list.add(arr[right]);
                right++;
            }
            else if(left >=0 && right >= arr.length){
                list.add(arr[left]);
                left--;
            }
            else {
                if(Math.abs(x-arr[left]) <= Math.abs(x-arr[right])){
                    list.add(arr[left]);
                    left--;
                }
                else {
                    list.add(arr[right]);
                    right++;
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}