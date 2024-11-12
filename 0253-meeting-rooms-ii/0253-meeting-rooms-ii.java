class Solution {
    public int minMeetingRooms(int[][] intervals) {
    // interval 크기
    int len = intervals.length;

    // 시작점 오름차순 정렬
    List<Integer> startPosition = Arrays.stream(intervals).map(interval -> interval[0]).sorted().collect(Collectors.toList());

    // 종료점 오름차순 정렬
    List<Integer> endPosition = Arrays.stream(intervals).map(interval -> interval[1]).sorted().collect(Collectors.toList());

    // 시작점, 종료점 포인터
    int startPointer = 0, endPointer = 0;

    // 방 개수
    int roomCount = 0;

    // 시작점 반복
    while (startPointer < len) {
      int start0 = startPosition.get(startPointer);
      int end0 = endPosition.get(endPointer);
      // 시작점 > 종료점 => 종료점 증분
      if (start0 >= end0) {
        roomCount -= 1;
        endPointer++;
      }
      roomCount += 1;
      startPointer++;
    }

    return roomCount;
  }
}