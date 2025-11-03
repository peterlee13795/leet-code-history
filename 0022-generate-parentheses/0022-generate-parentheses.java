class Solution {
    // answer
    List<String> answer = new ArrayList<>();

    // chars
    char[] targets;

    // size
    int size;
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.size = n * 2;
        targets = new char[size];

        // dfs
        dfs(0, 0, 0);

        return answer;
    }

    void dfs(int currentIndex, int openCount, int closeCount) {
        // 재 개수가 6개 인 경우 답변 추가 & return
        if(currentIndex == size) {
            answer.add(new String(targets));
            return;
        }

        // 열기
        // 조건1: 열기 개수가 n개 보다 작을 경우
        if(openCount < n) {
            // 열기 입력 & 다음 dfs call
            targets[currentIndex] = '(';
            dfs(currentIndex + 1, openCount + 1, closeCount);
        }
        
        
        // 닫기
        // 조건1: 열기 개수가 남아있는 경우
        // 조건2: 닫기 개수가 n개보다 작을 경우
        int leftOpenCount = openCount - closeCount;
        if(leftOpenCount > 0 && closeCount < n) {
            // 닫기 입력 & 다음 dfs call
            targets[currentIndex] = ')';
            dfs(currentIndex + 1, openCount, closeCount + 1);
        }
    }
}