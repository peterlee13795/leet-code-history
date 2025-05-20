class Solution {
    int xLimit = 0;
    int yLimit = 0;
    boolean[][] visits;
    char[][] board;

    public int countBattleships(char[][] board) {
        // init (visits, count, xLimit, yLimit)
        yLimit = board.length;
        xLimit = board[0].length;
        visits = new boolean[yLimit][xLimit];
        this.board =board;
        int count = 0;

        // iterate boards
        for(int y = 0 ; y < yLimit; y++) {
            for(int x = 0 ; x < xLimit; x++) {
                boolean valid = !visits[y][x] && board[y][x] == 'X';
                if(!valid) continue;
                visits[y][x] = true;
                count++; // update count
                // call dfs and check if horizontal or vertical extend
                if(y + 1 < yLimit && board[y+1][x] == 'X') dfs(x, y + 1, true);
                else if(x + 1 < xLimit && board[y][x + 1] == 'X') dfs(x + 1, y, false);
            }
        }
        

        // return count
        return count;
    }

    void dfs(int x, int y, boolean isVertical) {

        visits[y][x] = true;

        // if isVertical => check bottom side
        if(isVertical && y + 1 < yLimit && board[y + 1][x] == 'X') dfs(x, y + 1, true);
        // else !isY => check right side
        else if (!isVertical && x + 1 < xLimit && board[y][x+1] == 'X') dfs(x + 1, y, false);
        
    }
}