class Solution {
    
    List<String> ret = new ArrayList<>();
    
    int []dr = {1,0,-1,0};
    int []dc = {0,-1,0,1};
    
    int n,m;
    
    boolean done[][];
    
    class Position {
        int i,j;
        Position(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    
    
    
    boolean rec(int i,int j,String word,int idx,char [][]brd){
        //System.out.println(i + " " + j + " " + idx + " " + word);
        if(idx==word.length()){
            ret.add(word);
            return true;
        }
        for(int k=0;k<4;k++){
            int ni = i + dr[k];
            int nj = j + dc[k];
            if(ni<0 || ni>=n || nj<0 || nj>=m)
                continue;            
            if(brd[ni][nj]==word.charAt(idx)){
                if(done[ni][nj])
                    continue;
                done[ni][nj] = true;
                if(rec(ni,nj,word,idx+1,brd))
                    return true;
                done[ni][nj] = false;
            }
        }
        return false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        n = board.length;
        if(n == 0)
            return ret;
        m = board[0].length;
        Map<Character,List<Position>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char c = board[i][j];
                if(!map.containsKey(c)){
                    map.put(c,new ArrayList<>());
                }
                map.get(c).add(new Position(i,j));
            }
        }
        for(String word: words){
            char c = word.charAt(0);
            for(Position p:map.getOrDefault(c,new ArrayList<>())){
                done = new boolean[n][m];
                done[p.i][p.j] = true;
                if(rec(p.i,p.j,word,1,board)){
                    break;
                }
            }
        }
        Collections.sort(ret);
        return ret;
    }
}