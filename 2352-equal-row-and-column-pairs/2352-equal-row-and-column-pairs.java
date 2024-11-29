class Solution {
    public int equalPairs(int[][] grid) {
        // 2중 for문에서 map<String, Int> counts x축, y축 추출
        // 서로 겹치는게 있다면 그 중 min개를 합산
        Map<String, Integer> xAxis = new HashMap<>();
        Map<String, Integer> yAxis = new HashMap<>();
        
        int len = grid.length;
        
        for(int y = 0; y < len; y++) {
            StringBuilder x0 = new StringBuilder();
            StringBuilder y0 = new StringBuilder();
            for(int x = 0; x < len; x++) {
                x0.append(grid[y][x]).append(",");
                y0.append(grid[x][y]).append(",");
            }
            String x1 = x0.toString();
            String y1 = y0.toString();
            xAxis.put(x1, xAxis.getOrDefault(x1, 0) + 1);
            yAxis.put(y1, yAxis.getOrDefault(y1, 0) + 1);
        }
        int answer = 0;
        for(String key: xAxis.keySet()) {
            Integer yCount = yAxis.get(key);
            if(yCount == null) continue;
            
            answer += (yCount * xAxis.get(key));
        }
        return answer;
        
    }
}