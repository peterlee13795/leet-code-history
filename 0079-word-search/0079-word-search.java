class Solution {
    boolean exist = false;
    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};
    int r, c;

    public boolean exist(char[][] board, String word) {
        this.r = board.length;
        this.c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != word.charAt(0)) continue;

                dfs(new boolean[r][c], board, word, 1, i, j);

                if (exist) return true;
            }
        }

        return false;
    }

    void dfs(boolean[][] visits, char[][] boards, String word, int index, int i, int j) {
        if (visits[i][j] || exist) return;
        visits[i][j] = true;

        if (index == word.length()) {
            exist = true;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int i2 = i + dr[k];
            int j2 = j + dc[k];

            if (i2 < 0 || i2 >= r || j2 < 0 || j2 >= c) continue;
            if (boards[i2][j2] != word.charAt(index)) continue;

            dfs(visits, boards, word, index + 1, i2, j2);
        }

        // ✅ 핵심: 백트래킹 처리
        visits[i][j] = false;
    }
}
