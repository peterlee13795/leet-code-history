class Solution {
    public boolean isSubsequence(String s, String t) {
    char[] sources = s.toCharArray();
    if (sources.length == 0) {
      return true;
    }
    char[] targets = t.toCharArray();
    int j = 0;
    for (int i = 0, sourceLen = sources.length, targetLen = targets.length; i < sourceLen; i++) {
      char source = sources[i];
      boolean isSourceLast = i == sourceLen - 1;
      while (j < targetLen) {
        boolean isTargetLast = j == targetLen - 1;
        char target = targets[j++];
        if (source == target) {
          if (isSourceLast) {
            return true;
          }
          break;
        } else {
          if (isTargetLast) {
            return false;
          }
        }
      }
    }
    return false;
  }
}