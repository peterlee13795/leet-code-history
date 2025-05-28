class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // init (진입차수: indgree, 인접리스트: adjusts: List[], 방문횟수)
        int[] indgree = new int[numCourses];
        List<Integer>[] graphs = new ArrayList[numCourses];
        for(int i= 0 ; i < numCourses; i ++) graphs[i] = new ArrayList<>();
        

        // course 반복처리
        for(int[] prerequisite: prerequisites) {
            // from, to
            int from = prerequisite[1];
            int to = prerequisite[0];
            // 진입차수 및 인접리스트 추가
            indgree[to]++;
            graphs[from].add(to);
        }    

        // bfs 큐 초기화
        Queue<Integer> queue =new LinkedList<>();

        // 진입차수 == 0 인 코스 큐 add
        for(int i =0 ; i < numCourses; i ++) {
            if(indgree[i] == 0) {
                queue.add(i);
            }
        }

        int canTake = 0;
        // 큐 반복문
        while(!queue.isEmpty()) {
            int course = queue.poll();
            canTake++;

            // 인접리스트 반복문
            for(int nextCourse: graphs[course]) {
                // 진입차수--
                indgree[nextCourse]--;

                // if(진입차수 == 0) 큐.add
                if(indgree[nextCourse] == 0) queue.add(nextCourse);
            }
        }
            

        // return 방문횟수 == numCourses
        return canTake == numCourses;
    }
}