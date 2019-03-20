import java.util.*;
import java.lang.*;

class Pair {
    int x;
    int y;

    public Pair(int a, int b) {
        x = a;
        y = b;
    }
}

class Chainlength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0, j = 0; i < 2 * n - 1 && j < n; i = i + 2, j++) {
                pr[j] = new Pair(arr[i], arr[i + 1]);
            }
            GfG g = new GfG();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}

class CompareByLast implements Comparator<Pair> {
    @Override
    public int compare(Pair arg0, Pair arg1) {
        return Integer.compare(arg0.y, arg1.y);
    }
}

class GfG {
    int maxChainLength(Pair arr[], int n) {
        // your code here
        Arrays.sort(arr,new CompareByLast());
        int curr = arr[0].y;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (curr < arr[i].x) {
                curr = arr[i].y;
                cnt++;
            }
        }
        return cnt;
    }
}
