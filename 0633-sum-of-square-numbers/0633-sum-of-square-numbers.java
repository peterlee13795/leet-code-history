class Solution {
    public boolean judgeSquareSum(int c) {
        // 제한 구하기
        int limit = (int)Math.sqrt(c);

        // 투포인터 (양끝), a = 0, b = limit
        long a = 0;
        long b = limit;
        
        // 투포인터 반복
        while(a <= b) {
            // sum = a^2 + b^2 
            long sum = (a * a) + (b * b);

            // if(sum == c) return true
            if(sum == c) return true;
            // else if(sum > c) => b--
            else if (sum > c) b--;
            // else a++
            else a++;
        }
        return false;
    }
}