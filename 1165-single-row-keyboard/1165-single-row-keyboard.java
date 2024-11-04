class Solution {
    public int calculateTime(String keyboard, String word) {
    char[] characters = keyboard.toCharArray();
    int len = characters.length;
    int[] characterIndex = new int[128];

    for (int i = 0; i < len; i++) {
      characterIndex[characters[i]] = i;
    }
    char[] requiredCharacters = word.toCharArray();
    int moves = 0;
    int lastIndex = 0;
    for (int i = 0, wordLen = requiredCharacters.length; i < wordLen; i++) {
      int requiredIndex = characterIndex[requiredCharacters[i]];
      moves += Math.abs(requiredIndex - lastIndex);
      lastIndex = requiredIndex;
    }

    return moves;
  }
}