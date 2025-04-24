class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    // init len, ylen, xlen
    int ylen = matrix.length;
    int xlen = matrix[0].length;

    // init left, right
    int left = 0;
    int right = (ylen * xlen) - 1;

    // iterate left <= right
    while (left <= right) {
      // get mid
      int mid = left + (right - left) / 2;
      // get value = matrix[mid / ylen][mid % xlen]
      int value = matrix[mid / xlen][mid % xlen];
      if (value == target) {
        return true;
      }
      if (value < target) {
          left = mid + 1;
        
      } else {
          right = mid - 1;
      }
    }
    return false;
  }
}