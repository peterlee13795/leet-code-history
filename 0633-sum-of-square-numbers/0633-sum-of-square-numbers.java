class Solution {
    public boolean judgeSquareSum(int c) {
        // 제한 n^(1/2)
        int limit = (int) Math.sqrt(c);

        // 반복문 a: 1 ~ 제한
        for(int a = 0 ; a <= limit; a++) {
            long aPower = a * a;
            int left = 0;
            int right = limit;
            // 이진탐색을 통해 b 찾기
            while(left <= right) {
                int mid = left + (right - left) / 2;
                long bPower = mid * mid;
                long sum = aPower + bPower;
                if(sum == c) return true;
                else if (sum < c) left = mid + 1;
                else right = mid - 1;
            }
        }

        // return false
        return false;
    }
}