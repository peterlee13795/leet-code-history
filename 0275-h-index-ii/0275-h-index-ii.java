class Solution {
    public int hIndex(int[] citations) {
    /**
     * 아이디어
     * 1. binary search
     * 2. 검사값 citation 수치가 asc 대상 citation 개수 이상인지 검증
     */

    // 0. init (len, max)
    int max = 0;
    int len = citations.length;

    // 1. get left, right
    int left = 0;
    int right = len - 1;

    // 2. iterate binary search
    while (left <= right) {
      // 3. get mid
      int mid = left + (right - left) / 2;

      // 4. get right left-over citation
      int rightLeftOver = len - mid;

      // 5. check if citation count is bigger than leftover citation count
      int citationCount = citations[mid];

      // 6. if bigger than -> max = hindex, left = mid + 1
      if (citationCount >= rightLeftOver) {
        max = Math.max(max, rightLeftOver);
        right = mid - 1;
      } else {
        // 7. else right = mid - 1
        left = mid + 1;
      }
    }
    // return max
    return max;
  }
}