class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26]; // 문자 등장 횟수
        boolean[] visited = new boolean[26]; // 이미 스택에 포함된 문자 여부

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            count[c - 'a']--;

            if (visited[c - 'a']) continue;

            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}