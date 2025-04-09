class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    // init (len, 인접리스트, 답-리스트)
    int len = pid.size();
    Map<Integer, List<Integer>> adjusts = new HashMap<>();
    List<Integer> answer = new ArrayList<>();

    // 부모-자식 인접리스트 charge
    for(int i =0 ; i < len ; i ++) {
      int ppidVal = ppid.get(i);
      if(ppidVal == 0) continue;
      adjusts.computeIfAbsent(ppidVal, k -> new ArrayList<>()).add(pid.get(i));
    }

    // 큐 반복
    Queue<Integer> queue = new LinkedList<>();
    queue.add(kill);

    // 정리 대상 추가
    while (!queue.isEmpty()) {
      int ppidVal = queue.poll();
      answer.add(ppidVal);
      if(adjusts.containsKey(ppidVal)) {
        queue.addAll(adjusts.get(ppidVal));  
      }
    }

    // return
    return answer;
  }
}