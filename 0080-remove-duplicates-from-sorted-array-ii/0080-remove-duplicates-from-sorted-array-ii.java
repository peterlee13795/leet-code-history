
import java.util.stream.Collectors;

class Solution {

   public int removeDuplicates(int[] nums) {
    Map<Integer, Long> counts = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    AtomicLong result = new AtomicLong();
    AtomicInteger index = new AtomicInteger();

    counts.keySet().stream().sorted().forEach(eachValue -> {
      long eachCount = Math.min(counts.get(eachValue), 2);
      int currentIndex = index.get();
      result.addAndGet(eachCount);
      for (int i = 0; i < eachCount; i++) {
        nums[i + currentIndex] = eachValue;
      }
      index.addAndGet((int) eachCount);
    });

    return (int) result.get();
  }
}