class Solution {
    public boolean canPermutePalindrome(String s) {
    char[] characters = s.toCharArray();
    int[] characterCount = new int[128];
    for (char character : characters) {
      characterCount[character]++;
    }
    int len = characters.length;
    boolean isOdd = len % 2 == 1;
    int oddCount = 0;
    for (int i = 0; i < 128; i++) {
      if (characterCount[i] % 2 == 1) {
        oddCount++;
      }
    }
    return isOdd ? oddCount == 1 : oddCount == 0;
  }
}