class Solution {
    boolean[] visits;
    int len;
    public int findCircleNum(int[][] isConnected) {
        // 길이
        len = isConnected.length;
        
        // 방문여부
        visits = new boolean[len];
        
        int count = 0;
        
        // 2중 반복문
        for(int i = 0; i < len; i++) {
            if(visits[i]) continue;
            dfs(isConnected, i);
            count++;
        }
        
        // return
        return count;
    }
    
    void dfs(int[][] isConnected, int start) {
        if(visits[start]) return;
        visits[start] = true;
        for(int i = 0 ; i< len; i++) {
            if(!visits[i] && isConnected[start][i] == 0) continue;
            dfs(isConnected, i);
        }
    }
}