class Solution {
    public boolean isArmstrong(int n) {
        int k = 0;
        int remain = n;
        while(true) {
            remain = remain / 10;
            k++;
            if(remain == 0) break;
        }
        int sum = 0;
        for(char v: String.valueOf(n).toCharArray()) {
            int r = v - '0';
            int m = 1;
            for(int i =0 ; i < k ; i++) {
                m *= r;
            }
            sum += m;
        }
        return sum == n;
    }
}