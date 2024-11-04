class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
    // 길이가 다르면 false
    if (sentence1.length != sentence2.length) {
      return false;
    }

    // simular mapper 정의 (simularPair의 키-값 2쌍)
    Map<String, Set<String>> mapper1 = new HashMap<>();
    Map<String, Set<String>> mapper2 = new HashMap<>();

    // simuar key-value 정리
    for (List<String> similarPair : similarPairs) {
      String value1 = similarPair.get(0);
      String value2 = similarPair.get(1);
      mapper1.computeIfAbsent(value1, value0 -> new HashSet<>());
      mapper2.computeIfAbsent(value2, value0 -> new HashSet<>());
      mapper1.get(value1).add(value2);
      mapper2.get(value2).add(value1);
    }

    for (int i = 0, len = sentence1.length; i < len; i++) {
      String word1 = sentence1[i];
      String word2 = sentence2[i];
      if (word1.equals(word2)) {
        continue; // 동일 여부 체크
      }

      // 양방향 체크
      Set<String> set1 = mapper1.get(word1);
      Set<String> set2 = mapper2.get(word1);
      if (set1 != null && set1.contains(word2)) {
        continue;
      }
      if (set2 != null && set2.contains(word2)) {
        continue;
      }

      return false; // simular 가 아님
    }

    return true; // 체크 완료되어서 simular sentences
  }
}