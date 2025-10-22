class Solution {
    int xlen = 0;
    int ylen = 0;
    int[] ydir = new int [] {-1,1,0,0};
    int[] xdir = new int[] {0,0,-1,1};
    int slen = 0;

    public boolean exist(char[][] board, String word) {
        // direction list
        this.ylen = board.length;
        this.xlen = board[0].length;
        this.slen = word.length();

        // dfs call

        // iterate chars (y, x)
        for(int yi = 0 ; yi < ylen; yi++) {
            for(int xi = 0; xi < xlen; xi++) {
                if(board[yi][xi] != word.charAt(0)) continue;
                if(slen == 1) return true;
                boolean[][] visits = new boolean[ylen][xlen];
                visits[yi][xi] = true; // 시작점 방문 표시

                if(dfs(board, visits, word, yi, xi, 1)) return true;
            }
        }
        
        return false;
    }

    boolean dfs(char[][] board, boolean[][] visits, String word, int y, int x, int index) {
        // iterate dir
        for(int i = 0; i < 4; i++) {
            int ny = y + this.ydir[i];
            int nx = x + this.xdir[i];
            if(ny < 0 || ny == this.ylen) continue;
            if(nx < 0 || nx == this.xlen) continue;                
            if(board[ny][nx] != word.charAt(index)) continue;
            if(visits[ny][nx]) continue;
            visits[ny][nx] = true;
            if(index == this.slen - 1) return true;
            if(dfs(board, visits, word, ny, nx, index+1)) return true;
            visits[ny][nx] = false;
        }

        return false;
    }
}