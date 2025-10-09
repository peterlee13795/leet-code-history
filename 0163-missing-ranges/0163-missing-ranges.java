class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
    final int len = nums.length;
    if (len == 0) { // edge-case (nums.length == 0)
      return Collections.singletonList(Arrays.asList(lower, upper));
    }

    final List<List<Integer>> list = new ArrayList<>(); // 정답 리스트 정의

    if (lower < nums[0]) { // lower ~ nums[0]
      list.add(Arrays.asList(lower, nums[0] - 1));
    }

    // left, right 포인터, 1씩 증분
    for (int lindex = 0, rindex = 1; rindex < len; lindex++, rindex++) {
      if (nums[lindex] + 1 < nums[rindex]) { // 값이 2 이상 차이난다면 빈 공간이 있으므로 삽입
        list.add(Arrays.asList(nums[lindex] + 1, nums[rindex] - 1));
      }
    }

    if (upper > nums[len - 1]) { // nums[len - 1] ~ upper
      list.add(Arrays.asList(nums[len - 1] + 1, upper));
    }

    return list;
  }
}