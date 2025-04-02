class Solution {
    Map<Character, List<Character>> map = new HashMap<>();
  List<String> answer = new ArrayList<>();
  char[] node;
  int len;

  public List<String> letterCombinations(String digits) {
    // init
    this.len = digits.length();
    if(this.len == 0) return answer;
    
    this.node = new char[len];
    map.put('2', Arrays.asList('a', 'b', 'c'));
    map.put('3', Arrays.asList('d', 'e', 'f'));
    map.put('4', Arrays.asList('g', 'h', 'i'));
    map.put('5', Arrays.asList('j', 'k', 'l'));
    map.put('6', Arrays.asList('m', 'n', 'o'));
    map.put('7', Arrays.asList('p', 'q', 'r', 's'));
    map.put('8', Arrays.asList('t', 'u', 'v'));
    map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

    // iterate digits
    backtracking(digits, 0);

    // return
    return answer;
  }

  private void backtracking(String digits, int index) {
    if (index == len) {
      answer.add(new String(node));
      return;
    }
    List<Character> targets = map.get(digits.charAt(index));
    for (char target : targets) {
      node[index] = target;
      backtracking(digits, index + 1);
    }
  }
}