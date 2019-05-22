import java.util.*;

class Solution {
    Map<String, List<String>> adj = new HashMap<>();
    Map<String, Integer> dist = new HashMap<>();
    int oo = 987654321;

    List<String> nextWords(char[] word, Set<String> dict) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                word[i] = c;
                if (dict.contains(String.valueOf(word)))
                    list.add(String.valueOf(word));
            }
        }
        return list;
    }

    static class state {
        String v;
        int cost;
        String path;

        state(String v, int cost, String path) {
            this.v = v;
            this.cost = cost;
            this.path = path;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();
        Queue<state> q = new ArrayDeque<>();
        q.offer(new state(beginWord, 0, beginWord));
        dist.put(beginWord, 0);
        int optimalCost = -1;
        while (!q.isEmpty()) {
            state curr = q.poll();
            String u = curr.v;
            int cost = curr.cost;
            String path = curr.path;
            if (u.equals(endWord)) {
                if (cost == optimalCost || optimalCost == -1) {
                    String[] tokens = path.split(" ");
                    List<String> list = new ArrayList<>();
                    for (String w : tokens) {
                        list.add(w);
                    }
                    ans.add(list);
                    optimalCost = cost;
                }

            }
            if (dist.getOrDefault(u, oo) < cost)
                continue;
            List<String> currList;
            if (!adj.containsKey(u)) {
                adj.put(u, nextWords(u.toCharArray(), dict));
            }
            currList = adj.get(u);
            for (String v : currList) {
                if (dist.getOrDefault(v, oo) >= cost + 1) {
                    dist.put(v, cost + 1);
                    q.offer(new state(v, cost + 1, path + " " + v));
                }
            }
        }
        return ans;
    }
}