class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        Arrays.fill(grid[0], 1);
        for(int y = 1 ; y < m ; y++) {
            for(int x = 0; x < n; x++) {
                if(x == 0) grid[y][0] = 1;
                else grid[y][x] = grid[y - 1][x] + grid[y][x - 1];
            }
        }
        return grid[m - 1][n - 1];
    }
}