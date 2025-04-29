class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        /**
         * 아이디어1: 값 기준으로 mid를 찾을 것 (이진탐색)
         * 아이디어2: mid 기준으로 앞 쪽 개수를 count 할 것 (row, column 정렬되어있으니, 투-포인터)
         * 아이디어3: 개수 추출 결과가 k보다 작으면 right = mid, 크다면 left = mid + 1
         */

        // 바이너리 검색 (logN^2)
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        // 중간값 찾기
        while(left < right) {
            // 중간값 아래 개수 구하기 (2N)
            int mid = left + (right - left) / 2;

            int count = count(matrix, mid);

            // 중간값 개수보다 크다면 -> left = mid + 1
            if(count < k) left = mid + 1;
                // 중간값 개수보다 작다면 -> right = mid
            else right = mid;

        }
        // return left
        return left;
    }

    private int count(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        int count = 0;
        while(row >= 0 && col < matrix[0].length) {
            if(matrix[row][col] <= target) {
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}