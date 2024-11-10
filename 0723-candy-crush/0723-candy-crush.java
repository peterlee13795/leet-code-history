class Solution {
    int rowLen, colLen;

    public int[][] candyCrush(int[][] board) {
        rowLen = board.length;
        colLen = board[0].length;
        Set<Pair<Integer, Integer>> crushedSet = findCandy(board);
        while (!crushedSet.isEmpty()) {
            crushCandy(board, crushedSet);
            dropCandy(board);
            crushedSet = findCandy(board);
        }

        return board;
    }



    private Set<Pair<Integer, Integer>> findCandy(int[][] board) {
        Set<Pair<Integer, Integer>> crushedSet = new HashSet<>();

        // 수직 찾기
        for (int rindex = 1; rindex < rowLen - 1; rindex++) {
            for (int cindex = 0; cindex < colLen; cindex++) {
                if (board[rindex][cindex] == 0) continue;

                if (board[rindex][cindex] == board[rindex - 1][cindex] && board[rindex][cindex] == board[rindex + 1][cindex]) {
                    crushedSet.add(new Pair<>(rindex, cindex));
                    crushedSet.add(new Pair<>(rindex - 1, cindex));
                    crushedSet.add(new Pair<>(rindex + 1, cindex));
                }
            }
        }

        // 수평 찾기
        for (int ridx = 0; ridx < rowLen; ridx++) {
            for (int cidx = 1; cidx < colLen - 1; cidx++) {
                if (board[ridx][cidx] == 0) {
                    continue;
                }
                if (board[ridx][cidx] == board[ridx][cidx - 1] && board[ridx][cidx] == board[ridx][cidx + 1]) {
                    crushedSet.add(new Pair<>(ridx, cidx));
                    crushedSet.add(new Pair<>(ridx, cidx - 1));
                    crushedSet.add(new Pair<>(ridx, cidx + 1));
                }
            }
        }
        return crushedSet;
    }

    private void crushCandy(int[][] board, Set<Pair<Integer, Integer>> crushedSet) {
        // 대상 candy crush
        for (Pair<Integer, Integer> pair : crushedSet) {
            int ridx = pair.getKey();
            int cidx = pair.getValue();
            board[ridx][cidx] = 0;
        }
    }

    private void dropCandy(int[][] board) {
        for (int cidx = 0; cidx < colLen; cidx++) { // x축 조회
            int zeroIndex = -1;
            
            for (int ridx = rowLen - 1; ridx >= 0; ridx--) { // 밑에서부터 위로
                if (board[ridx][cidx] == 0) {
                    zeroIndex = Math.max(zeroIndex, ridx); // 하단 0 값 찾기
                } else if (zeroIndex >= 0) {
                    int temp = board[ridx][cidx];
                    board[ridx][cidx] = board[zeroIndex][cidx];
                    board[zeroIndex][cidx] = temp;
                    zeroIndex--;
                }
            }
        }
    }
}