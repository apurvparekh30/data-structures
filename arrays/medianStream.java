import java.util.*;
import java.io.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    


    public static void main(String[] args) {
        int n = fs.nextInt();
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        int median = 0;
        while(n-- > 0){
            int x = fs.nextInt();
            if(min.size() == max.size()){
                if(x < median){
                    max.offer(x);
                    median = max.peek();
                }
                else{
                    min.offer(x);
                    median = min.peek();
                }
            }
            else if(min.size() > max.size()){
                if(x > median){
                    max.offer(min.peek());
                    min.poll();
                    min.offer(x);
                }
                else{
                    max.offer(x);
                }
                median = (max.peek() + min.peek())/2;
            }
            else {
                if(x < median){
                    min.offer(max.peek());
                    max.poll();
                    max.offer(x);
                }
                else{
                    min.offer(x);
                }
                median = (max.peek() + min.peek())/2;
            }
            System.out.println(median);
        }
    }
}