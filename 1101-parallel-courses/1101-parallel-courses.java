class Solution {
    public int minimumSemesters(int n, int[][] relations) {
    // init (receiveCount: int[], nextCourses: List<Integer>[], queue<Integer>)
    int[] receiveCounts = new int[n + 1];
    List<Integer>[] nextCourses = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      nextCourses[i] = new ArrayList<>();
    }
    Queue<Integer> queue = new LinkedList<>();

    // iterate relations to charge receiveCount
    for (int[] row : relations) {
      int prevCourseIndex = row[0];
      int nextCourseIndex = row[1];
      nextCourses[prevCourseIndex].add(nextCourseIndex);
      receiveCounts[nextCourseIndex]++;
    }

    for (int i = 1; i <= n; i++) {
      if (receiveCounts[i] == 0) {
        queue.add(i);
      }
    }
    if (queue.isEmpty()) {
      return -1;
    }

    // init nextBfsCount = queue.size()
    int visitsCount = 0;
    // init semesterCount = 0
    int semesterCount = 0;

    // bfs iterate
    while (!queue.isEmpty())  {
      // add semester
      semesterCount++;
      
      // index iterate
      for(int i= 0, size = queue.size(); i < size; i ++) {
        visitsCount++;
        
        // poll queue
        int previousCourseIndex = queue.poll();
        // iterate nextCourses
        for(int nextCourseIndex: nextCourses[previousCourseIndex]) {
          // decrease receiveCount
          // if(0 == receiveCount) => add to queue
          if(--receiveCounts[nextCourseIndex] == 0) {
            queue.add(nextCourseIndex);
          }
        }
        
        
      }
    }

    // return semesterCount
    return visitsCount == n ? semesterCount : -1;
  }
}