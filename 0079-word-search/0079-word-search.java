class Solution {

    boolean[][] visits;
    char[][] board;
    char[] chars;
    int wlen;
    int ylen;
    int xlen;
    
    int[] ydir = {-1,1,0,0};
    int[] xdir = {0,0,1,-1};

    public boolean exist(char[][] board, String word) {
        /**
         * 전략
         *  dfs
         * 1. word 별 일치하는게 있는지 확인
         * 2. 진입할 때, 방문여부 체크
         * 3. 방문이 완료되었다면 방문여부 롤백
         * 4. dfs 함수 호출하면서 단어 검증 => true|false
         * 5. 만약 현재 단어가 마지막 단어라면 true
         * 6. 4방향 이동
         */
        this.ylen = board.length;
        this.xlen = board[0].length;
        this.wlen = word.length();
        this.visits = new boolean[this.ylen][this.xlen];
        this.board = board;
        this.chars = word.toCharArray();
        
        for(int y=0; y < this.ylen; y++) {
            for(int x=0; x < this.xlen; x++) {
                if(dfs(y, x, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    boolean dfs(int y, int x, int clen) {
        if(this.board[y][x] != this.chars[clen]) return false;
        if(clen == this.wlen - 1) return true;
        this.visits[y][x] = true;
        
        for(int i = 0 ; i < 4; i++) {
            int ny = y + this.ydir[i];
            int nx = x + this.xdir[i];
            if(ny <0 || ny >= this.ylen || nx < 0 || nx >= this.xlen || this.visits[ny][nx]) continue;
            if(dfs(ny, nx, clen + 1)) {
                return true;
            }
        }
        this.visits[y][x] = false;
        return false;
    }
}