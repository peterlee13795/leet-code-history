class MyCalendar {
    TreeMap<Integer, Integer> books;
    public MyCalendar() {
        books = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        // 평균시간복잡도: log(n)

        // TreeMap: 레드블랙트리로써, 탐색에는 log(n) 지원

        // case1: treeMap의 floorKey를 이용해 기존_시작, 기존_종료 확인 => 기존_시작은 신규_시작보다 같거나 작으므로, 기존_종료가 신규_시작보다 크다면 겹침
        Integer originStartTime_1 = books.floorKey(startTime);
        if(originStartTime_1 != null && books.get(originStartTime_1) > startTime) return false;

        // case2: treeMap의 ceilingKey를 이용해 기존_시작, 기존_종료 확인 => 기존_시작은 신규_시작보다 같거나 크므로, 기존_시작이 신규_종료보다 작다면 겹침
        Integer originStartTime_2 = books.ceilingKey(startTime);
        if(originStartTime_2 != null && originStartTime_2 < endTime) return false;

        // 통과되면, treeMap에 삽입
        books.put(startTime, endTime);

        // return true
        return true;

        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */