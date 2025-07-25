class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int len = nums.length;
        
        // 정렬
        Arrays.sort(nums);
        
        // 고정값 반복문 (중복값 방지)
        for(int i =0; i < len; i++) {
            
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            
            // 투포인트
            int left = i+1, right = len - 1;
            while(left < right) {
                
                // 투포인트 증분
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    
                    while(left > i+1 && left < right && nums[left] == nums[left-1]) left++;
                    while(right < len - 1 && left < right && nums[right] == nums[right+1]) right--;
                }
            }
        }
        
        return answer;
    }
}