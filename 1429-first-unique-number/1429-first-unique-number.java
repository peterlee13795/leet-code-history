class FirstUnique {

   Map<Integer, Integer> numCount = new HashMap<>();
  Queue<Integer> order = new LinkedList<>();

  public FirstUnique(int[] nums) {
    for (int num : nums) {
      add(num);
    }
  }

  public int showFirstUnique() {
    if (order.isEmpty()) {
      return -1;
    }
    int count = 2;
    while (count > 1 && !order.isEmpty()) {
      int nowValue = order.peek();
      count = numCount.get(nowValue);
      if (count == 1) {
        return nowValue;
      } else {
        order.poll();
      }
    }
    return -1;
  }

  public void add(int value) {
    int oldCount = numCount.computeIfAbsent(value, (v0) -> 0);
    if (oldCount == 0) {
      order.add(value);
    }
    numCount.put(value, oldCount + 1);
  }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */