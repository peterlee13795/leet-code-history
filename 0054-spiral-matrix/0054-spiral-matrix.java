class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // xDir
        int xDir = 1;

        // yDir
        int yDir = 0;

        // index
        int xIndex = -1, yIndex = 0;

        // size
        int xLimit0 = 0;
        int xLimit1 = matrix[0].length - 1;
        int yLimit0 = 1;
        int yLimit1 = matrix.length - 1;
        int total = matrix.length * matrix[0].length;

        // answer
        List<Integer> answer = new ArrayList<>();

        // iterate
        while(answer.size() < total) {
            // next
            xIndex += xDir;
            yIndex += yDir;

            // process
            answer.add(matrix[yIndex][xIndex]);

            // if xDir == 1 && xInd == rowLen => xDir = 0, yDir = 1;
            if(xDir == 1 && xIndex == xLimit1) { // l0
                xDir = 0;
                yDir = 1;
                xLimit1--;
            } else if (yDir == 1 && yIndex == yLimit1) {
                xDir = -1;
                yDir = 0;
                yLimit1--;
            } else if (xDir == -1 && xIndex == xLimit0) {
                xDir = 0;
                yDir = -1;
                xLimit0++;
            } else if (yDir == -1 && yIndex == yLimit0) {
                xDir = 1;
                yDir = 0;
                yLimit0++;
            }
        }
        
        return answer;
    }
}