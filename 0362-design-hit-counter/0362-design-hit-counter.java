class HitCounter {

    // init(list<integer>)
    Deque<Integer> hits;

    public HitCounter() {
        this.hits = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        // add to list
        hits.addLast(timestamp);
    }
    
    public int getHits(int timestamp) {
        int start = Math.max(timestamp - 300, 0);
        while(!this.hits.isEmpty() && this.hits.peekFirst() <= start) {
            this.hits.pollFirst();
        }

        // return size - index
        return this.hits.size();
    }

}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */