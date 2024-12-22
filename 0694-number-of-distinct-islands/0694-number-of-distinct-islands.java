class Solution {
    public int numDistinctIslands(int[][] grid) {
        // 고유한 섬 모양을 저장할 Set
        Set<String> uniqueIslands = new HashSet<>();
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    // 섬 모양을 문자열로 저장
                    StringBuilder shape = new StringBuilder();
                    dfs(grid, i, j, shape, "o"); // 시작점 표시 (origin)
                    uniqueIslands.add(shape.toString());
                }
            }
        }
        
        // 고유한 섬의 개수 반환
        return uniqueIslands.size();
    }

    private void dfs(int[][] grid, int x, int y, StringBuilder shape, String direction) {
        // 범위를 벗어나거나, 방문한 위치(0)이면 종료
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }
        
        // 현재 위치 방문 처리
        grid[x][y] = 0;
        shape.append(direction);
        
        // 상, 하, 좌, 우로 탐색
        dfs(grid, x - 1, y, shape, "u"); // 위 (up)
        dfs(grid, x + 1, y, shape, "d"); // 아래 (down)
        dfs(grid, x, y - 1, shape, "l"); // 왼쪽 (left)
        dfs(grid, x, y + 1, shape, "r"); // 오른쪽 (right)
        
        // 백트래킹 시 복귀 경로 추가
        shape.append("b"); // back
    }
}