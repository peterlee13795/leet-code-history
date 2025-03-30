class Solution {
    public boolean isValidSudoku(char[][] board) {
        // column sets Set[]
        Set<Character>[] columns = new HashSet[9];
        for(int i =0 ; i < 9 ; i++) columns[i] = new HashSet<>();

        // grid sets Set[][]
        Set<Character>[][] grids = new HashSet[3][3];
        for(int i =0 ; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                grids[i][j] = new HashSet<>();
            }
        }

        // iterate row & cell
        for(int i =0 ; i < 9 ; i++) {
            Set<Character> row = new HashSet<>();
            char[] brow = board[i];
            for (int j = 0; j < 9; j++) {
                char t0 = brow[j];
                if(t0 == '.') continue;
                // check if duplicated
                if(!row.add(t0)) return false;
                if(!columns[j].add(t0)) return false;
                if(!grids[i / 3][j / 3].add(t0)) return false;
            }
        }

        return true;
    }
}