class Solution {
  // char list by curly brace
  List<Character[]> expandChars;

  // each answer char array
  char[] expandAnswer;

  List<String> expandAnswers;

  public String[] expand(String s) {
    // init
    expandChars = new ArrayList<>();
    expandAnswers = new ArrayList<>();

    boolean open = false;
    // parse s to [['a','b'],['c']...]
    List<Character> item = new ArrayList<>();
    for (int i = 0, len = s.length(); i < len; i++) {
      char c = s.charAt(i);
      if (c == '{') {
        open = true;
        if (!item.isEmpty()) {
          expandChars.add(item.toArray(new Character[0]));
        }
        item = new ArrayList<>();
      } else if (c == '}') {
        open = false;
        if (!item.isEmpty()) {
          expandChars.add(item.toArray(new Character[0]));
        }
        item = new ArrayList<>();
      } else if (c == ',') {
        continue;
      } else {
        item.add(c);
        if (!open) {
          if (!item.isEmpty()) {
            expandChars.add(item.toArray(new Character[0]));
          }
          item = new ArrayList<>();
        }
      }
    }

    expandAnswer = new char[expandChars.size()];

    // dfs
    dfs(0);

    // sort & toArray
    return expandAnswers.stream().sorted().toArray(String[]::new);
  }

  private void dfs(int index) {
    // iterate chars
    boolean isEnd = index + 1 == expandChars.size();
    for (Character expandChar : expandChars.get(index)) {
      expandAnswer[index] = expandChar;

      if (isEnd) { // if len == index+1, then add to expandAnswers
        expandAnswers.add(new String(expandAnswer));
      } else { // next dfs
        dfs(index + 1);
      }

    }


  }
}