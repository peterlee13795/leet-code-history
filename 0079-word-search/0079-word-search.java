class Solution {

    private final int[][] dirs = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    private boolean[][] visited;
    private int m, n;

    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index) {

        // 범위 체크
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }

        // 이미 방문한 칸
        if (visited[x][y]) {
            return false;
        }

        // 현재 문자가 다르면 실패
        if (board[x][y] != word.charAt(index)) {
            return false;
        }

        // 마지막 문자까지 찾은 경우
        if (index == word.length() - 1) {
            return true;
        }

        visited[x][y] = true;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (dfs(board, word, nx, ny, index + 1)) {
                return true;
            }
        }

        // 백트래킹
        visited[x][y] = false;

        return false;
    }
}