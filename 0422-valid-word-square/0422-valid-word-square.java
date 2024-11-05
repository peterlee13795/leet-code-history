class Solution {
    public boolean validWordSquare(List<String> words) {
    // word 순회
    // character 순회
    // word[i].length > j
    // word[j].length > i
    // word[i][j] != word[j][i]
    for (int ridx = 0, rlen = words.size(); ridx < rlen; ridx++) {
      String rWord = words.get(ridx);
      for (int cidx = 0, clen = words.get(ridx).length(); cidx < clen; cidx++) {
        if (cidx == rlen) {
          return false;
        }
        String cWord = words.get(cidx);
        if (cWord.length() <= ridx) {
          return false;
        }
        if (cWord.charAt(ridx) != rWord.charAt(cidx)) {
          return false;
        }
      }
    }
    return true;
  }
}