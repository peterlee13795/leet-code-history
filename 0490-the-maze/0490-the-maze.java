class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    // init(row, cell 1 treeSetY, treeSetX, visits, xlen, ylen, queue)
    int ylen = maze.length;
    int xlen = maze[0].length;
    boolean[][] visits = new boolean[ylen][xlen];

    TreeSet<Integer>[] xTreeSets = new TreeSet[xlen];
    for (int i = 0; i < xlen; i++) {
      xTreeSets[i] = new TreeSet<>();
    }
    TreeSet<Integer>[] yTreeSets = new TreeSet[ylen];
    for (int i = 0; i < ylen; i++) {
      yTreeSets[i] = new TreeSet<>();
    }

    for (int y = 0; y < ylen; y++) {
      for (int x = 0; x < xlen; x++) {
        if (maze[y][x] == 1) {
          xTreeSets[x].add(y);
          yTreeSets[y].add(x);
        }
      }
    }

    Queue<int[]> nextPoints = new LinkedList<>();
    nextPoints.add(start);

    // nextPoints
    while (!nextPoints.isEmpty()) {
      int[] point = nextPoints.poll();
      int y0 = point[0];
      int x0 = point[1];

      // check visit
      if (visits[y0][x0]) {
        continue;
      }

      // if destination == nowLocation, return true
      if (y0 == destination[0] && x0 == destination[1]) {
        return true;
      }

      visits[y0][x0] = true;

      // iterate four directions && add to queue
      Integer lx = yTreeSets[y0].floor(x0);
      Integer rx = yTreeSets[y0].ceiling(x0);
      nextPoints.add(new int[]{y0, lx == null ? 0 : lx + 1});
      nextPoints.add(new int[]{y0, rx == null ? xlen - 1 : rx - 1});

      Integer ty = xTreeSets[x0].floor(y0);
      Integer by = xTreeSets[x0].ceiling(y0);
      nextPoints.add(new int[]{ty == null ? 0 : ty + 1, x0});
      nextPoints.add(new int[]{by == null ? ylen - 1 : by - 1, x0});
    }

    // return false
    return false;
  }
}