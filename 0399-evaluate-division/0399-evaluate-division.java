class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        // 그래프 구성
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        // 결과 계산
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            result[i] = dfs(a, b, graph, new HashSet<>());
        }
        return result;
    }

    private double dfs(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) return -1.0;
        if (start.equals(end)) return 1.0;
        visited.add(start);

        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double product = dfs(neighbor.getKey(), end, graph, visited);
                if (product != -1.0) {
                    return product * neighbor.getValue();
                }
            }
        }
        return -1.0;
    }
}