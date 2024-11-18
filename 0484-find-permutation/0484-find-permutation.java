class Solution {
    public int[] findPermutation(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentIndex = -1;

        int len = s.length();
        int[] answer = new int[len + 1];
        for(int currentValue = 0; currentValue < len; currentValue++) {
            if(s.charAt(currentValue) == 'I') {
                stack.push(currentValue + 1);
                while (!stack.isEmpty()) {
                    answer[++currentIndex] = stack.pop();
                }
            } else {
                stack.add(currentValue + 1);
            }
        }
        stack.push(len + 1);
        while (!stack.isEmpty()) {
            answer[++currentIndex] = stack.pop();
        }

        return answer;
    }
}