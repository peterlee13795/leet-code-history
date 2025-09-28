class Solution {
    
    public int calculate(String s) {
        if (s == null) return 0;
        Queue<Character> q = new LinkedList();
        for (char c : s.toCharArray()) q.offer(c);
        return cal(q);
    }

    private int cal(Queue<Character> q) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        char previousOperation = '+';
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) { // 숫자
                num = 10 * num + c - '0';
            } else if ("+-*/".indexOf(c) != -1) { // 4칙연산
                eval(stack, num, previousOperation);
                num = 0;
                previousOperation = c;
            } else if (c == '(') { // open
                num = cal(q);
            } else if (c == ')') { // close
                break;
            }
        }
        eval(stack, num, previousOperation);
        return stack.stream().mapToInt(a -> a).sum();
    }

    private void eval(Stack<Integer> stack, int num, char op) {
        switch (op) {
            case '+':
                stack.push(num);
                break;
            case '-':
                stack.push(-num);
                break;
            case '*':
                stack.push(stack.pop() * num);
                break;
            case '/':
                stack.push(stack.pop() / num);
                break;
            default:
                break;
        }
    }
}