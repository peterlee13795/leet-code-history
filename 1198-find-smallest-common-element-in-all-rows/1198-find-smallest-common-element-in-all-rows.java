class Solution {
    public int smallestCommonElement(int[][] mat) {
    int[] counts = new int[10_001];

    for (int[] row : mat) {
      for (int col : row) {
        counts[col]++;
      }
    }
    for (int i = 0, rowLen = mat.length; i < 10_001; i++) {
      if (counts[i] == rowLen) {
        return i;
      }
    }
    return -1;
  }
}