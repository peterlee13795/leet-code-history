class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int answer = 0;
        boolean[] visits = new boolean[len];
        for(int i = 0 ; i < len; i ++) {
            if(visits[i]) continue;
            int n0 = nums[i];
            if(n0 >= k) continue;
            for(int j = i+1; j< len; j++) {
                if(visits[j]) continue;
                int s1 = n0 + nums[j];
                if(s1 > k) break;
                else if (s1 == k) {
                    visits[i] = true;
                    visits[j] = true;
                    answer++;
                    break;
                }
            }
        }
        return answer;
        // 1, 3, 3, 3, 4
        // 
    }
}