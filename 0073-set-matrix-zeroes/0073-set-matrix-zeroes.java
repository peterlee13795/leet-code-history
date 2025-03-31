class Solution {
    public void setZeroes(int[][] matrix) {
        // init
        int n = matrix.length;
        int m = matrix[0].length;

        // visits
        boolean[][] visits = new boolean[n][m];

        // iterate row, cell
        for(int y = 0 ; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(matrix[y][x] == 0 && !visits[y][x]) {
                    for(int x0 = 0; x0 < m; x0++) {
                        if(matrix[y][x0] != 0) visits[y][x0] = true;
                        matrix[y][x0] = 0;
                    }
                    for(int y0 = 0; y0 < n; y0++) {
                        if(matrix[y0][x] != 0) visits[y0][x] = true;
                        matrix[y0][x] = 0;
                    }
                }
            }
        }
    }
}