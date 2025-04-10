class Solution {
    public String parseTernary(String expression) {
    // init (characterStack, len, isCondition)
    Stack<Character> characterStack = new Stack<>();
    boolean isCondition = false;

    // iterate string reversely
    for(int i = expression.length() - 1; i >= 0; i--) {
      char nowCharacter = expression.charAt(i);
      if(isCondition) {
        // if(isCondition) => two pop and evaluate and add to stack
        char c0 = characterStack.pop();
        char c1 = characterStack.pop();
        characterStack.add(nowCharacter == 'T' ? c0 : c1);
      } else if (nowCharacter != ':' && nowCharacter != '?') {
        // else if (charAt != ':' && charAt != '?') => add to stack
        characterStack.add(nowCharacter);
      }
      // isCondition = charAt == '?'
      isCondition = nowCharacter == '?';
    }
    
    // return stack.pop()
    return String.valueOf(characterStack.pop());
  }
}