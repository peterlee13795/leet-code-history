class Solution {
    public String[] expand(String s) {
    // init characters: list<list<char>>, answer: character[], isCurly: boolean, answer: list<string>, len
    List<List<Character>> groupedCharacters = new ArrayList<>();
    boolean isCurly = false;
    int len = s.length();

    List<Character> characters = new ArrayList<>();

    // charge characters
    for(int i = 0 ; i < len ; i++) {
      char c0 = s.charAt(i);

      if(c0 == ',') {
        continue;
      } else if(c0 == '{') {
        isCurly = true;
        characters = new ArrayList<>();
        groupedCharacters.add(characters);
      } else if (c0 == '}') {
        isCurly = false;
      } else if(isCurly) {
        characters.add(c0);
      } else {
        groupedCharacters.add(Collections.singletonList(c0));
      }
    }

    // init char[] answer = new char[characters.size()];
    List<String> answer = new ArrayList<>();
    char[] answerPath = new char[groupedCharacters.size()];

    // dfs call
    dfs(groupedCharacters, answer, answerPath, 0);

    // return list to array
    Collections.sort(answer);
    return answer.toArray(new String[answer.size()]);
  }

  void dfs(List<List<Character>> groupedCharacters, List<String> answer, char[] answerPath, int index) {
    if(index == groupedCharacters.size()) {
      answer.add(new String(answerPath));
      return;
    }

    // iterate characters
    for(Character character: groupedCharacters.get(index)) {
      answerPath[index] = character;
      dfs(groupedCharacters, answer, answerPath, index + 1);
    }

  }
}