class Solution {
    public int minReorder(int n, int[][] connections) {
        // 그래프 생성
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] connection : connections) {
            int a = connection[0], b = connection[1];
            graph.get(a).add(new int[]{b, 1}); // 1: 원래 방향 a -> b
            graph.get(b).add(new int[]{a, 0}); // 0: 역방향 b -> a
        }

        // 방문 체크 및 방향 변경 횟수
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, Map<Integer, List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] neighbor : graph.get(node)) {
            int nextNode = neighbor[0];
            int isOriginal = neighbor[1];
            if (!visited[nextNode]) {
                changes += isOriginal; // 원래 방향이면 변경 필요
                changes += dfs(nextNode, graph, visited);
            }
        }

        return changes;
    }
    
}