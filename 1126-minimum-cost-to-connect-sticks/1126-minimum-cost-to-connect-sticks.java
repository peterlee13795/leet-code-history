class Solution {
    public int connectSticks(int[] sticks) {
    // init len, pqueue(asc)
    int len = sticks.length;
    PriorityQueue<Integer> pqueue = new PriorityQueue<>();

    // if len == 1 => return 0
    if(len == 1) return 0;

    // iterate sticks and add to queue
    for(int i = 0; i < len; i++) {
      pqueue.add(sticks[i]);
    }
    
    // init total
    int concat = pqueue.poll() + pqueue.poll();
    int total = concat;
    // poll twice in order to connect 2 smallest sticks
    pqueue.add(concat);

    // iterate until queue size == 1
    while(pqueue.size() > 1) {
      // poll twice, concat & add
      concat = pqueue.poll() + pqueue.poll();
      total += concat;
      pqueue.add(concat);
    }

    // return queue.poll
    return total;
  }
}