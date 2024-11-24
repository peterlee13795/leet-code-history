class Solution {
    public String largestPalindromic(String num) {
        // len
        int len = num.length();

        // 개수 mapper
        Map<Integer, Integer> counts = new HashMap<>();

        // 우선순위 큐 (내림차순)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        // set
        Set<Integer> holdings = new HashSet<>();

        // 데이터 쌓기
        for(int i =0 ; i < len; i ++) {
            int val = num.charAt(i) - '0';
            int count = counts.getOrDefault(val, 0);
            counts.put(val, count + 1);
            if(!holdings.contains(val)) {
                holdings.add(val);
                priorityQueue.add(val);
            }
        }

        // 답
        StringBuilder result = new StringBuilder();

        // 역방향 쌓기
        Stack<Integer> stack = new Stack<>();
        
        // count > 1인 것 추출 & 짝수 개수 증분
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
                stack.add(val);
            }
        }

        if(result.isEmpty() || result.charAt(0) == '0') {
            return oneAppear == null ? "0" : String.valueOf(oneAppear);
        }

        

        return result.toString() + (oneAppear != null ? oneAppear : "") + result.reverse();
    }
}