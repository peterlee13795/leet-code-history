class Solution {
    
    
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        // build the hashmap with count of occurence of every element in array
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = k - nums[i];
            
            if (map.getOrDefault(current, 0) == 0 || map.getOrDefault(complement, 0) == 0) continue;
            if (current == complement && map.get(current) == 1) continue;
            
            map.put(current, map.get(current) - 1);
            map.put(complement, map.get(complement) - 1);
            count++;
            
        }
        return count;
    }
    
}