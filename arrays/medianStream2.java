import java.util.*;
import java.io.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int[] arr;
    static int size = 0;

    static class MinHeap {
        int size = 0;
        int[] arr;

        MinHeap(int n) {
            arr = new int[n];
            size = 0;
        }
        public int parent(int i){
            return (i-1)/2;
        }
        public int left(int i){
            return i*2+1;
        }
        public int right(int i){
            return i*2+2;
        }
        public int top(){
            return arr[0];
        }
        public int size(){
            return size;
        }
        public void insert(int x) {
            size++;
            int i = size - 1;
            arr[i] = x;
            while(i!=0 && arr[parent(i)] > arr[i]){
                int temp = arr[parent(i)];
                arr[parent(i)] = arr[i];
                arr[i] = temp;
                i = parent(i);
            }
        }
        
        public void heapify(int i){
            if(i >= size)
                return;
            if(left(i) < right(i)){
                int temp = arr[i];
                arr[i] = arr[left(i)];
                arr[left(i)] = temp;
                heapify(left(i));
            }
            else {
                int temp = arr[i];
                arr[i] = arr[right(i)];
                arr[right(i)] = temp;
                heapify(right(i));
            }
        }
        public void delete(){
            size--;
            arr[0] = arr[size];
            heapify(0);
        }
        @Override
        public String toString(){
            return Arrays.toString(arr);
        }
    }

    static class MaxHeap {
        int size = 0;
        int[] arr;

        MaxHeap(int n) {
            arr = new int[n];
            size = 0;
        }
        public int parent(int i){
            return (i-1)/2;
        }
        public int left(int i){
            return i*2+1;
        }
        public int right(int i){
            return i*2+2;
        }
        public int top(){
            return arr[0];
        }
        public int size(){
            return size;
        }
        public void insert(int x) {
            size++;
            int i = size - 1;
            arr[i] = x;
            while(i!=0 && arr[parent(i)] < arr[i]){
                int temp = arr[parent(i)];
                arr[parent(i)] = arr[i];
                arr[i] = temp;
                i = parent(i);
            }
        }
        
        public void heapify(int i){
            if(i >= size)
                return;
            if(left(i) > right(i)){
                int temp = arr[i];
                arr[i] = arr[left(i)];
                arr[left(i)] = temp;
                heapify(left(i));
            }
            else {
                int temp = arr[i];
                arr[i] = arr[right(i)];
                arr[right(i)] = temp;
                heapify(right(i));
            }
        }
        public void delete(){
            size--;
            arr[0] = arr[size];
            heapify(0);
        }
        @Override
        public String toString(){
            return Arrays.toString(arr);
        }
    }

    public static void main(String[] args) {
        int n = fs.nextInt();
        arr = new int[n];
        MaxHeap s = new MaxHeap(n);
        MinHeap g = new MinHeap(n);
        s.insert(fs.nextInt());
        System.out.println(s.top());
        int med = 0;
        while (n-- > 1) {
            int x = fs.nextInt();
            if(s.size() == g.size()){
                if(x < med){
                    s.insert(x);
                    med = s.top();
                }
                else{
                    g.insert(x);
                    med = g.top();
                }
            }
            else if(s.size() > g.size()){
                if(x < med){
                    g.insert(s.top());
                    s.delete();
                    s.insert(x);
                }else {
                    g.insert(x);
                }
                med = (s.top() + g.top())/2;
            }
            else {
                if(x > med){
                    s.insert(g.top());
                    g.delete();
                    g.insert(x);
                }else {
                    s.insert(x);
                }
                med = (s.top() + g.top())/2;
            }
            System.out.println(med);
        }
    }
}