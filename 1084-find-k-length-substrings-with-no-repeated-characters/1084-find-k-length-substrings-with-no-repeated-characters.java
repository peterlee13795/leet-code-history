class Solution {
    char[] characters;
  Map<Character, Integer> counts = new HashMap<>();

  public int numKLenSubstrNoRepeats(String s, int k) {
    characters = s.toCharArray();
    int len = characters.length;
    if (len < k) {
      return 0;
    }

    // lindex, rindex;
    int lIndex = 0;
    int rIndex = k - 1;

    append(lIndex, rIndex);

    int count = distinct(lIndex, rIndex) ? 1 : 0;

    while (rIndex < len - 1) {
      remove(lIndex++);
      append(++rIndex);
      if (distinct(lIndex, rIndex)) {
        count++;
      }
    }

    return count;
  }

  public void append(int from, int to) {
    for (int i = from; i <= to; i++) {
      append(i);
    }
  }

  public void append(int index) {
    char character = characters[index];
    counts.put(character, counts.getOrDefault(character, 0) + 1);
  }

  public void remove(int index) {
    char character = characters[index];
    int count = counts.get(character);
    if (count == 1) {
      counts.remove(character);
    } else {
      counts.put(character, count - 1);
    }
  }

  public boolean distinct(int from, int to) {
    for (int i = from; i <= to; i++) {
      int count = counts.getOrDefault(characters[i], 0);
      if (count != 1) {
        return false;
      }
    }
    return true;
  }
}