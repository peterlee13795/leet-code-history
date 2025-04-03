class Solution {
    TreeSet<Integer>[] xWalls;
    TreeSet<Integer>[] yWalls;
    int[][] shortestPaths;
    int ylen, xlen;
    int shortest;
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // init (treeMap, visits, xlen, ylen, queue)
        shortest = Integer.MAX_VALUE;
        this.ylen = maze.length;
        this.xlen = maze[0].length;
        this.shortestPaths = new int[ylen][xlen];

        this.xWalls = new TreeSet[xlen];
        this.yWalls = new TreeSet[ylen];
        for(int i= 0 ; i < xlen; i ++) this.xWalls[i] = new TreeSet<>();
        for(int i= 0 ; i < ylen; i ++) this.yWalls[i] = new TreeSet<>();

        // iterate maze and recharge treeMap
        for(int y =0 ; y < ylen; y++) {
            for(int x =0 ; x < xlen; x++) {
                shortestPaths[y][x] = Integer.MAX_VALUE;
                if(maze[y][x] == 1) {
                    this.yWalls[y].add(x);
                    this.xWalls[x].add(y);
                }
            }
        }

        // call dfs
        dfs(start, destination, 0);

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private void dfs(int[] point, int[] destination, int dist) {
        int y0 = point[0];
        int x0 = point[1];

        // 방문여부
        if(shortestPaths[y0][x0] <= dist) return;

        shortestPaths[y0][x0] = dist;

        // 목적지 확인
        if(y0 == destination[0] && x0 == destination[1]) {
            shortest = Math.min(shortest, dist);
            return;
        }

        // 4방향 이동
        // lx
        Integer lx = yWalls[y0].floor(x0);
        lx = lx == null ? 0 : lx + 1;
        dfs(new int[] {y0, lx}, destination, dist + x0 - lx);

        // rx
        Integer rx = yWalls[y0].ceiling(x0);
        rx = rx == null ? xlen - 1 : rx - 1;
        dfs(new int[] {y0, rx}, destination, dist + rx - x0);

        // ty
        Integer ty = xWalls[x0].floor(y0);
        ty = ty == null ? 0 : ty + 1;
        dfs(new int[] {ty, x0}, destination, dist + y0 - ty);

        // by
        Integer by = xWalls[x0].ceiling(y0);
        by = by == null ? ylen - 1 : by - 1;
        dfs(new int[] {by, x0}, destination, dist + by - y0);
    }
}