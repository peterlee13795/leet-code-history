class Solution {
  public int[] anagramMappings(int[] nums1, int[] nums2) {
    int len = nums1.length;
    Map<Integer, List<Integer>> indexMapping = new HashMap<>();
    for (int i = 0; i < len; i++) {
      int num2 = nums2[i];
      List<Integer> indexes = indexMapping.computeIfAbsent(num2, k -> new ArrayList<>());
      indexes.add(i);
    }
    int[] answer = new int[len];
    for (int i = 0; i < len; i++) {
      int num1 = nums1[i];
      List<Integer> indexes = indexMapping.get(num1);
      answer[i] = indexes.get(0);
      indexes.remove(0);
    }
    return answer;
  }
}