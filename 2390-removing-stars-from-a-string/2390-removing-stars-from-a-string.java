class Solution {
    public String removeStars(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int len = s.length();
        for(int i= 0 ; i < len ; i++) {
            char each = s.charAt(i);
            if(each == '*') {
                deque.pollLast();
            } else {
                deque.addLast(each);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        
        return sb.toString();
    }
}