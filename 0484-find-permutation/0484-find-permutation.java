class Solution {
    public int[] findPermutation(String s) {
    // init (size, stack)
    int len = s.length() + 1;
    int cursor = 0;
    Stack<Integer> stack = new Stack<>();

    int[] answer = new int[len];

    // iterate s
    for (int i = 0; i < len; i++) {
      // push stack
      stack.add(i + 1);

      // if D => continue
      if (i == len - 1 || s.charAt(i) == 'I') {
        while (!stack.isEmpty()) {
          answer[cursor++] = stack.pop();
        }
      }
    }
    return answer;
  }
}