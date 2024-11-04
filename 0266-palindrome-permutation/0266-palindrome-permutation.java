class Solution {
    public boolean canPermutePalindrome(String s) {
    char[] characters = s.toCharArray();
    int[] characterCount = new int[128];
    for (char character : characters) {
      characterCount[character]++; // character 개수 증분
    }

    int oddCount = 0; // character 홀수 개수
    for (int i = 0; i < 128; i++) {
      if (characterCount[i] % 2 == 1) {
        oddCount++;
      }
    }

    boolean isOdd = characters.length % 2 == 1; // 문자 홀수 여부
    return isOdd ? oddCount == 1 : oddCount == 0;
  }
}