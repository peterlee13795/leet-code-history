class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    // 아이디어: iterate y & binary search
    // 가정1: 정렬되어있음 y * log(x)
    
    // 0. init (xlen)
    int xlen = matrix[0].length;
    
    
    // 1. iterate y
    for(int[] row: matrix) {
      // get left, right
      int left = 0;
      int right = xlen - 1;

      // iterate binary search
      while(left <= right) {
        // get mid
        int mid = left + (right - left) / 2;

        // if(target == mid) return true
        if(row[mid] == target) return true;
        if(target > row[mid]) left = mid + 1;
        else right = mid - 1;
      }
    }
    // return false
    return false;
  }
}