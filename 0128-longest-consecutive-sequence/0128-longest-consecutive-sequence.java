class Solution {
    public int longestConsecutive(int[] nums) {
    // nums to set
    Set<Integer> sets = new HashSet<>();
    for (int num : nums) sets.add(num);  

    // longest
    int longest = 0;

    // iterate set
    for (int num : sets) {
      // find starting point in consequence
      if (sets.contains(num - 1)) continue;
      
      // find next point and increase stack
      int currentLen = 1;
      int currentNum = num;
      while (sets.contains(++currentNum)) currentLen++;
      
      longest = Math.max(longest, currentLen);
    }
    
    return longest;
  }
}