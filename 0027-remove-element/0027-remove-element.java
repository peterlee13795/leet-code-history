class Solution {
    public int removeElement(int[] nums, int val) {
    int count = 0;
    List<Integer> list = new ArrayList<>();
    for (int num : nums) {
      if (num != val) {
        list.add(num);
      }
    }
    int len = list.size();
    for(int i= 0 ; i < len; i ++) {
      nums[i] = list.get(i);
    }
    return list.size();
  }
}