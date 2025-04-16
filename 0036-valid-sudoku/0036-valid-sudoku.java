class Solution {
    public boolean isValidSudoku(char[][] board) {
    // init xAxis count, yAxis count, square count Set<Integer>[]
    Set<Integer>[] xAxis = new HashSet[9];
    Set<Integer>[] yAxis = new HashSet[9];
    Set<Integer>[][] subSquare = new HashSet[3][3];
    for(int i =0 ; i < 9; i++) {
      xAxis[i] = new HashSet<>();
      yAxis[i] = new HashSet<>();
      subSquare[i / 3][i % 3] = new HashSet<>();
    }
    
    // iterate xrow and yrow
    for(int y = 0 ; y < 9; y++) {
      for(int x = 0 ; x < 9; x++) {
        // check three axis (x, y, subSquare if contains)
        if(board[y][x] == '.') continue;
        int value = board[y][x] - '0';
        if(!xAxis[x].add(value)) return false;
        if(!yAxis[y].add(value)) return false;
        if(!subSquare[y / 3][x / 3].add(value)) return false;
      }
    }
    
    // return false if not found any
    return true;
  }
}