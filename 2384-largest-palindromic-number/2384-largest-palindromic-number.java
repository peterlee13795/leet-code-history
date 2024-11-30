class Solution {
   public String largestPalindromic(String num) {

        // 개수 mapper
        Map<Integer, Integer> counts = new HashMap<>();

        // 내림차순 큐
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());


        // 데이터 쌓기
        for(int i =0, len = num.length(); i < len; i ++) {
            int val = num.charAt(i) - '0';
            int count = counts.getOrDefault(val, 0);
            counts.put(val, count + 1);
            if(count == 0) {
                priorityQueue.add(val);
            }
        }

        // 답
        StringBuilder result = new StringBuilder();
        
        // count > 1인 것 모두 주출 & 짝수 개수 증분
        Integer oneAppear = null;
        while (!priorityQueue.isEmpty()) {
            int val = priorityQueue.poll();
            int count = counts.get(val);
            int halfCount = count / 2;
            if(count % 2 == 1) {
                if(oneAppear == null || oneAppear < val) {
                    oneAppear = val;
                }
            }
            for(int i = 0; i < halfCount; i++) {
                result.append(val);
            }
        }
        
        boolean isLeadingZero = result.isEmpty() || result.charAt(0) == '0';
        if(isLeadingZero) {
            return oneAppear == null ? "0" : String.valueOf(oneAppear);
        }
       
        String prefix = result.toString();
        String center = oneAppear != null ? String.valueOf(oneAppear) : "";
        String postfix = result.reverse().toString();
       
        return String.format("%s%s%S", prefix, center, postfix);
    }
}