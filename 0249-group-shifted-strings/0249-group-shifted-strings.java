class Solution {
   public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> answer = new ArrayList<>();
    // map: { "order": index }
    Map<String, Integer> indexCache = new HashMap<>();

    for (String string : strings) {
      String groupKey = groupKey(string); // 그룹 키값
      int targetIndex = indexCache.computeIfAbsent(groupKey, groupKey0 -> { // 그룹 키 index
        answer.add(new ArrayList<>());
        return answer.size() - 1;
      });
      List<String> grouped = answer.get(targetIndex);
      grouped.add(string);
    }
    return answer;
  }

  private String groupKey(String word) {
    int len = word.length();
    int pivot = word.charAt(0);
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < len; i++) {
      char character = word.charAt(i);
      stringBuilder.append((character - pivot + 26) % 26 + 'a');
    }
    return stringBuilder.toString();
  }
}