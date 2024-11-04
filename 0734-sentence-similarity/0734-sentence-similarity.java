class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
    if (sentence1.length != sentence2.length) {
      return false;
    }

    Map<String, Set<String>> mapper1 = new HashMap<>();
    Map<String, Set<String>> mapper2 = new HashMap<>();

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
      if (word1.equals(word2)) continue;
      Set<String> set1 = mapper1.get(word1);
      Set<String> set2 = mapper2.get(word1);
      if (set1 != null && set1.contains(word2)) continue;
      if (set2 != null && set2.contains(word2)) continue;
      return false;
    }
    return true;
  }
}