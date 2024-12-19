class Solution {
    List<Integer>[] connections;
    boolean[] visits;
    public int countComponents(int n, int[][] edges) {
        // bi-direction mapper map<int, list<int>>
        connections = new ArrayList[n];
        for(int i = 0 ; i < n ; i++) connections[i] = new ArrayList<>();
        for(int[] edge: edges) {
            connections[edge[0]].add(edge[1]);
            connections[edge[1]].add(edge[0]);
        }
        
        // boolean[] connected to confirm
        visits = new boolean[n];
        
        // iterate n
        int answer = 0;
        for(int i= 0 ; i < n ; i++) {
            if(visits[i]) continue;
            // if not visited, count++ and dfs
            answer++;
            dfs(i);
        }
        return answer;
    }
    
    void dfs(int index) {
        if(visits[index]) return;
        visits[index] = true;
        for(int next: connections[index]) {
            dfs(next);
        }
    }
}