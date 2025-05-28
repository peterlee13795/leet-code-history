class Solution {
    int m, n;
    boolean[][] visits;
    public int numIslands(char[][] grid) {
        // init (visits, count, m, n)
        m = grid.length;
        n = grid[0].length;
        visits = new boolean[m][n];
        int count = 0;

        for(int y =0 ; y < m; y ++) {
            for(int x = 0; x < n; x++) {
                if(visits[y][x]) continue;
                if(grid[y][x] != '1') continue;
                count++;
                dfs(grid, y, x);
            }
        }
        return count;
        
    }

    void dfs(char[][] grid, int y, int x) {
        if(visits[y][x]) return;
        visits[y][x] = true;
        int y0 = y + 1;
        int y1 = y - 1;
        int x0 = x + 1;
        int x1 = x - 1;
        if(y0 < m && grid[y0][x] == '1') dfs(grid, y0, x);
        if(x0 < n && grid[y][x0] == '1') dfs(grid, y, x0);
        if(y1 >= 0 && grid[y1][x] == '1') dfs(grid, y1, x);
        if(x1 >= 0 && grid[y][x1] == '1') dfs(grid, y, x1);
    }
}