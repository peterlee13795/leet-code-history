class Solution {
    List<String> answer;
    public List<String> generateParenthesis(int n) {
        // init (char[n*2])
        answer = new ArrayList<>();
        char[] target = new char[n * 2];
        target[0] = '(';

        // backtrack
        backtrack(target, 1, n, 1, 0, 1);

        // return
        return answer;
    }

    private void backtrack(char[] target, int index, int limit, int openCount, int closeCount, int priorOpen) {
        // if(index == limit) => answer.add(char), continue;
        if(index == limit * 2) {
            answer.add(new String(target));
            return;
        }

        /**
         * case1: open이 오는 상황
         *  open 개수가 n / 2 이하일 경우 => if(openCount < limit / 2) => char[index] = open; openCount++; priorOpen++;
         * case2: close가 오는 상황
         *  앞선 open 개수가 1개 이상 => if(priorOpen > 0 && closeCount < limit / 2) => char[index] = close; closeCount++;
         */
        if(openCount < limit) {
            target[index] = '(';
            backtrack(target, index+1, limit, openCount + 1, closeCount, priorOpen + 1);
        }
        if(closeCount < limit && priorOpen > 0) {
            target[index] = ')';
            backtrack(target, index+1, limit, openCount, closeCount + 1, priorOpen - 1);
        }
    }
}