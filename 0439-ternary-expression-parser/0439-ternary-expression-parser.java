class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop(); // '?' 제거
                char trueVal = stack.pop(); // 참일 때 값
                stack.pop(); // ':' 제거
                char falseVal = stack.pop(); // 거짓일 때 값
                
                // 조건에 따라 적절한 값 push
                stack.push(c == 'T' ? trueVal : falseVal);
            } else {
                stack.push(c);
            }
        }
        
        return String.valueOf(stack.peek());
    }
}