class Solution {
    public int[] twoSum(int[] nums, int target) {
        // define map (key=num, val=index)
        Map<Integer, Integer> map = new HashMap<>(); 
        
        // iterate nums
        for(int i = 0,len = nums.length; i < len; i++) {
            // check if left over (target - nums[i]) exists in map
            int leftover = target - nums[i];
            // if exist => return
            if(map.containsKey(leftover)) {
                return new int[] {map.get(leftover), i };
            }
            
            // put nums[i] to map    
            map.put(nums[i], i);
            
        }
        return null;
    }
}