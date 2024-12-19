class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        // 그래프를 인접 리스트로 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // 목적지 노드에서 다른 노드로 이어지는 간선이 있다면 false
        if (!graph.get(destination).isEmpty()) {
            return false;
        }

        // DFS를 사용하여 모든 경로 확인
        return dfs(graph, source, destination, new boolean[n], new boolean[n]);
    }

    private boolean dfs(List<List<Integer>> graph, int node, int destination, boolean[] visited, boolean[] onPath) {
        // 이미 현재 경로에서 방문한 노드면 사이클이므로 false
        if (onPath[node]) {
            return false;
        }

        // 이미 확인된 노드라면 true
        if (visited[node]) {
            return true;
        }

        // 목적지 노드에서 종료 조건 확인
        if (graph.get(node).isEmpty()) {
            return node == destination;
        }

        // 현재 노드를 경로에 추가
        visited[node] = true;
        onPath[node] = true;

        // 모든 인접 노드 탐색
        for (int neighbor : graph.get(node)) {
            if (!dfs(graph, neighbor, destination, visited, onPath)) {
                return false;
            }
        }

        // 경로에서 제거
        onPath[node] = false;
        return true;
    }

    
}