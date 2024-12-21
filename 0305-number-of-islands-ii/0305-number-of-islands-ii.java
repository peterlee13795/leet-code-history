class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (m <= 0 || n <= 0) return result;

        int[] parent = new int[m * n];
        int[] rank = new int[m * n];
        Arrays.fill(parent, -1);

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;

        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            int index = r * n + c;

            if (parent[index] != -1) {
                result.add(count);
                continue; // 이미 처리된 땅
            }

            parent[index] = index; // 자신의 부모를 자신으로 설정
            count++; // 새로운 섬 추가

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                int neighborIndex = nr * n + nc;

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && parent[neighborIndex] != -1) {
                    if (union(index, neighborIndex, parent, rank)) {
                        count--; // 두 섬이 연결되었으므로 섬 개수 감소
                    }
                }
            }

            result.add(count);
        }

        return result;
    }

    private int find(int x, int[] parent) {
        if (x != parent[x]) {
            parent[x] = find(parent[x], parent); // 경로 압축
        }
        return parent[x];
    }

    private boolean union(int x, int y, int[] parent, int[] rank) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
        return false;
    }
}