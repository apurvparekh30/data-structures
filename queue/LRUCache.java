import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            Set<Integer> s = new HashSet<Integer>();
            int n = sc.nextInt();
            LRUCache g = new LRUCache(n);
            int q = sc.nextInt();

            while (q > 0) {

                String c = sc.next();
                // System.out.println(c);
                if (c.equals("GET")) {
                    int x = sc.nextInt();
                    System.out.print(g.get(x) + " ");
                }
                if (c.equals("SET")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    g.set(x, y);
                }

                q--;
                // System.out.println();
            }
            t--;
            System.out.println();
        }
    }
}

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

/* You are required to complete below class */
class LRUCache {

    Deque<Integer> dq;
    Map<Integer, Integer> cache;
    int size;

    /* Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        dq = new ArrayDeque<>();
        cache = new HashMap<>();
        this.size = N;
    }

    /*
     * Returns the value of the key x if present else returns -1
     */
    public int get(int x) {
        if (cache.containsKey(x)) {
            dq.removeFirstOccurrence(x);
            dq.addLast(x);
            return cache.get(x);
        }
        return -1;
    }

    /* Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        if(cache.containsKey(x)){
            dq.removeFirstOccurrence(x);
        }
        else{
            if(cache.size()==size){
                cache.remove(dq.pollFirst());
            }
        }
        cache.put(x,y);
        dq.addLast(x);
    }
}
