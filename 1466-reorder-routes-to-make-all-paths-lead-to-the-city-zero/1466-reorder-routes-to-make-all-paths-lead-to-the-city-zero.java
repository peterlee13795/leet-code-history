class Solution {
    public int minReorder(int n, int[][] connections) {
        // 그래프 생성 (양방향 그래프)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] conn : connections) {
            // 원래 방향: conn[0] -> conn[1] (1로 표시)
            graph.get(conn[0]).add(new int[]{conn[1], 1});
            // 반대 방향: conn[1] -> conn[0] (0으로 표시)
            graph.get(conn[1]).add(new int[]{conn[0], 0});
        }

        // BFS 탐색
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;

        int changes = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int[] neighbor : graph.get(current)) {
                int nextNode = neighbor[0];
                int direction = neighbor[1];

                if (!visited[nextNode]) {
                    // 방향이 맞지 않으면 변경 필요
                    changes += direction;
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }

        return changes;
    }
    
}