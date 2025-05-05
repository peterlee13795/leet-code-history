class MyCalendar {
    List<int[]> books; // 0: 시작, 1: 종료

    public MyCalendar() {
        books = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        // books 반복문, 시간복잡도 o(n)
        for(int[] book: books) {
            // case1: 신규_시작 <= 기존_시작 && 신규_종료 > 기존_시작
            if(startTime <= book[0] && endTime > book[0]) return false;
            // case2: 신규_시작 >= 기존_시작 && 신규_종료 <= 기존_종료
            if(startTime >= book[0] && endTime <= book[1]) return false;
            // case3: 신규_시작 < 기존_종료 && 신규_종료 >= 기존_종료
            if(startTime < book[1] && endTime >= book[1]) return false;
        }

        books.add(new int[] {startTime, endTime});
        // 충돌 조건 없음
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */