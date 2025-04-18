class Solution {
    public int singleNumber(int[] nums) {
        // init (duplicate sets, singleSets)
        Set<Integer> duplicateSets = new HashSet<>();
        Set<Integer> singleSets = new HashSet<>();
        
        // iterate nums O(n)
        for(int num: nums) {
            // add to duplicateSets and check if it inserted before => O(1)
            if(duplicateSets.add(num)) {
                // if not inserted, add to singleSets => O(1)
                singleSets.add(num);
            } else {
                // if inserted before, remove from singleSets => O(1)
                singleSets.remove(num);
            }
        }
        
        return singleSets.iterator().next();
    }
}