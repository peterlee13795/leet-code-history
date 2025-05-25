
class Solution {
  public int[] platesBetweenCandles(String s, int[][] queries) {
    int[] ans = new int[queries.length];
    List<Integer> candleIndices = new ArrayList<>();

    // 양초의 인덱스를 기록
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '|') {
        candleIndices.add(i);
      }
    }

    // 각 쿼리에 대해 접시 개수 계산
    for (int i = 0; i < queries.length; ++i) {
      int left = queries[i][0];
      int right = queries[i][1];
      int l = firstGreaterEqual(candleIndices, left);
      int r = firstGreaterEqual(candleIndices, right + 1) - 1;
      if (l < r) {
        int lengthBetweenCandles = candleIndices.get(r) - candleIndices.get(l) + 1;
        int numCandles = r - l + 1;
        ans[i] = lengthBetweenCandles - numCandles;
      }
    }

    return ans;
  }

  // 이진 탐색을 통해 target 이상인 첫 번째 인덱스를 찾음
  private int firstGreaterEqual(List<Integer> indices, int target) {
    int index = Collections.binarySearch(indices, target);
    return index < 0 ? -index - 1 : index;
  }
}