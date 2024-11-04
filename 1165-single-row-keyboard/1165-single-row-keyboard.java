class Solution {
    public int calculateTime(String keyboard, String word) {
    char[] characters = keyboard.toCharArray(); // 키보드 배열
    int len = characters.length;
    int[] characterIndex = new int[128]; // 문자 인덱스

    for (int i = 0; i < len; i++) {
      characterIndex[characters[i]] = i; // 문자 <-> 인덱스 값
    }
    char[] requiredCharacters = word.toCharArray(); // word 배열
    int moves = 0; // 이동 값
    int lastIndex = 0; // 마지막 이동 인덱스
    for (int i = 0, wordLen = requiredCharacters.length; i < wordLen; i++) {
      int requiredIndex = characterIndex[requiredCharacters[i]]; // word character index
      moves += Math.abs(requiredIndex - lastIndex); // 현재 이동 경로
      lastIndex = requiredIndex; 
    }

    return moves;
  }
}