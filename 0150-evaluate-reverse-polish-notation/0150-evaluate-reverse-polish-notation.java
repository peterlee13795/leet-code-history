class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> sets = new HashSet<>(Arrays.asList("/", "*", "+", "-"));


        for(String token: tokens) {
            if(sets.contains(token)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                if("/".equals(token)) stack.add(String.valueOf(a / b));
                else if("*".equals(token)) stack.add(String.valueOf(a * b));
                else if("-".equals(token)) stack.add(String.valueOf(a - b));
                else stack.add(String.valueOf(a + b));
            } else {
                stack.add(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    
}