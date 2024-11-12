class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
    // intervals 시작 점 기준 오름차순 정렬 (logn * n) (n = 10^4)
    List<int[]> sortedIntervals = Arrays.stream(intervals).sorted(Comparator.comparing(interval -> interval[0])).collect(Collectors.toList());

    Integer lastEndTime = -1;
    for (int[] interval : sortedIntervals) {
      // 이전 종료가 다음 시작보다 크다면 실패
      if(lastEndTime > interval[0]) return false;
      lastEndTime = interval[1];
    }
    return true;
  }
}