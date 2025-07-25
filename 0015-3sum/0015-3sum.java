class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    // init (answer, length)
    List<List<Integer>> answer = new ArrayList<>();


    // remove duplicated values (to hashSet)
    Set<Integer> sets = new HashSet<>();
    for(int num: nums) { // o(n)
      sets.add(num);
    }
    // sort nums & to list
    List<Integer> sorted = sets.stream().sorted().toList(); // o(nlong)
    int len = sorted.size();

    // iterate from 0 to n-2
    for(int i =0 ; i < len - 2; i ++) { // o(n^2)
      int fixed = sorted.get(i);
      int lindex = i + 1;
      int rindex = len - 1;

      while (lindex < rindex) {
        int sum = fixed + sorted.get(lindex) + sorted.get(rindex);
        if(sum == 0) {
          answer.add(Arrays.asList(fixed, sorted.get(lindex), sorted.get(rindex)));
          lindex++;
          rindex--;
        } else if (sum < 0) {
          lindex++;
        } else {
          rindex--;
        }
      }
    }
    
    return answer;
  }
}