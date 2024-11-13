class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
    // 정답 정의
    List<List<Integer>> answer = new ArrayList<>();

    // 반복문
    for (int[] interval : intervals) {
      if (interval[0] > toBeRemoved[1] || interval[1] < toBeRemoved[0]) { // 삭제-범위와 포함-범위는 완전 벗어남
        answer.add(Arrays.asList(interval[0], interval[1]));
      } else { // 삭제 범위 포함됨
        if (interval[0] < toBeRemoved[0]) {
          answer.add(Arrays.asList(interval[0], toBeRemoved[0]));
        }
        if (interval[1] > toBeRemoved[1]) {
          answer.add(Arrays.asList(toBeRemoved[1], interval[1]));
        }
      }
    }
    return answer;
  }
}