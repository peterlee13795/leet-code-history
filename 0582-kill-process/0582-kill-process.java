class Solution {
   public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // map<Integer, List<Intger>> tree; {key=pid,value=cpid}
        Map<Integer, List<Integer>> tree = new HashMap<>();
        int len = ppid.size();
        for(int i= 0 ;i < len; i++) {
            tree.computeIfAbsent(ppid.get(i), (key) -> new ArrayList<>()).add(pid.get(i));
        }

        List<Integer> answer = new ArrayList<>();
        answer.add(kill);

        // tree kill and follow until not found
        List<Integer> empty = new ArrayList<>();  
        
        Queue<Integer> queue = new LinkedList<>(tree.getOrDefault(kill, empty));
        while (!queue.isEmpty()) {
            Integer next = queue.poll();
            answer.add(next);
            queue.addAll(tree.getOrDefault(next, empty));
        }
        return answer;
    }
    
    
}