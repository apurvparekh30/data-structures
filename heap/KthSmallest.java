import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static int []arr;
    static int k;

    static int left(int i){
        return i * 2 + 1;
    }
    static int right(int i){
        return i * 2 + 2;
    }
    static int parent(int i){
        return (i-1)/2;
    }
    static int top(){
        return arr[0];
    }
    static void heapify(int i){
        int left = left(i);
        int right = right(i);
        
        if(left >= n && right >=n)
            return;
        
        
        int index = (right >= n) ? left : (arr[left] <= arr[right] ? left : right);

        if(arr[i] < arr[index])
            return;

        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
        heapify(index);
    }

    static void buildHeap(){
        int start = (n-2)/2;
        for(int i=start;i>=0;i--){
            heapify(i);
        }
    }

    static void delete(){
        n--;
        arr[0] = arr[n];
        heapify(0);
    }

    public static void main(String[] args) {
        int tc = fs.nextInt();
        while(tc-- > 0){
            n = fs.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = fs.nextInt();
            k = fs.nextInt();
            if(n == 1){
                System.out.println(arr[0]);
                continue;
            }
            //System.out.println(Arrays.toString(arr));
            buildHeap();
            //System.out.println(Arrays.toString(arr));
            while(k-- > 1){
                delete();
            }
            System.out.println(top());
        }
    }
}