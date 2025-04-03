class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    int ylen = maze.length;
    int xlen = maze[0].length;
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
    int[][] shortestPaths = new int[ylen][xlen];

    TreeSet<Integer>[] xWalls = new TreeSet[xlen];
    for (int i = 0; i < xlen; i++) xWalls[i] = new TreeSet<>();
    TreeSet<Integer>[] yWalls = new TreeSet[ylen];
    for (int i = 0; i < ylen; i++) yWalls[i] = new TreeSet<>();
    for (int y = 0; y < ylen; y++) {
        for (int x = 0; x < xlen; x++) {
            shortestPaths[y][x] = Integer.MAX_VALUE;
            if (maze[y][x] == 1) {
                xWalls[x].add(y);
                yWalls[y].add(x);
            }
        }
    }

    queue.add(new Node(start[1], start[0], 0));

    while (!queue.isEmpty()) {
        Node node = queue.poll();
        if (shortestPaths[node.y][node.x] <= node.dist) continue;
        shortestPaths[node.y][node.x] = node.dist;

        // left
        Integer lx = yWalls[node.y].floor(node.x);
        lx = lx == null ? 0 : lx + 1;
        queue.add(new Node(lx, node.y, node.dist + (node.x - lx)));

        // right
        Integer rx = yWalls[node.y].ceiling(node.x);
        rx = rx == null ? xlen - 1 : rx - 1;
        queue.add(new Node(rx, node.y, node.dist + (rx - node.x)));

        // top
        Integer ty = xWalls[node.x].floor(node.y);
        ty = ty == null ? 0 : ty + 1;
        queue.add(new Node(node.x, ty, node.dist + (node.y - ty)));

        // bottom
        Integer by = xWalls[node.x].ceiling(node.y);
        by = by == null ? ylen - 1 : by - 1;
        queue.add(new Node(node.x, by, node.dist + (by - node.y)));
    }

    int result = shortestPaths[destination[0]][destination[1]];
    return result == Integer.MAX_VALUE ? -1 : result;
}

static class Node {
    int x, y, dist;

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

}