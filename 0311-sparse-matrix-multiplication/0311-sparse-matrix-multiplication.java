class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
    int ylen0 = mat1.length; // mat1의 y축
    int xlen0 = mat1[0].length; // mat1의 x축(=mat2의 y축)
    int xlen1 = mat2[0].length; // mat2의 x축
    int[][] result = new int[ylen0][xlen1]; // [mat1.y * mat2.x]
    
    // mat1의 y축 반복문 for(int y0 = 0; y0 < ylen0; y0++)
    for(int y0 = 0; y0 < ylen0; y0++) {
      //  mat2의 x축 반복문 for(int x1 = 0; x1 < xlen1; x1++)
      for(int x1 = 0; x1 < xlen1; x1++) {
        int sum = 0; // 합산
        // mat1의 x축(=mat2의 y축) 반복문 for(int x0 = 0; x0 < xlen0; x0++)
        for(int x0 = 0; x0 < xlen0; x0++) {
          // 합산 sum += (mat1[y0][x0] + mat2[x0][x1])
          sum += (mat1[y0][x0] * mat2[x0][x1]);
        }
        // 합산 대입, result[y0][x1] = sum;
        result[y0][x1] = sum;
      }
    }
    return result;
  }
}