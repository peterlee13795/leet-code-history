class Solution {
   public int findLonelyPixel(char[][] picture) {
    // 행렬의 열 'B' 개수 배열 int[] columnCount
    int columnLen = picture[0].length;
    int[] columnCount = new int[columnLen];

    // for(char[] row: picture)
    //   for(char col: row)   // 반복문
    // row에 black이 1개임을 보장
    for (char[] row : picture) {
      for (int columnIndex = 0; columnIndex < columnLen; columnIndex++) {
        if (row[columnIndex] == 'B') {
          columnCount[columnIndex]++;
        }
      }
    }

    int blackCount = 0;
    for (char[] row : picture) {
      int rowBlackCount = 0;
      int rowBlackIndex = 0;
      for (int columnIndex = 0; columnIndex < columnLen; columnIndex++) {
        if (row[columnIndex] == 'B') {
          rowBlackCount++;
          rowBlackIndex = columnIndex;
        }
      }
      if (rowBlackCount == 1 && columnCount[rowBlackIndex] == 1) {
        blackCount++;
      }
    }

    return blackCount;
  }
}