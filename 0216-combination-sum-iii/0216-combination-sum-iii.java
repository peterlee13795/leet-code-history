class Solution {
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] visits = new boolean[10];
        
        dfs(0, 1, n, k, 0, new boolean[10]);
        
        return answer;
    }
    
    private void dfs(int totalVal, int startVal, int targetVal, int totalIndex, int currentIndex, boolean[] visits) {
        // if(totalIndex == currentIndex)
        //  if(totalVal == targetVal) 
        //   visits[i] = true, i=> add
        //  return;
        if(currentIndex == totalIndex) {
            if(totalVal == targetVal) {
                List<Integer> values = new ArrayList<>();
                for(int i = 1; i < 10; i++) {
                    if(!visits[i]) continue;
                    values.add(i);
                }
                answer.add(values);
            }
            return;
        }
        
        // 1~9 반복
        for(int currentVal = startVal; currentVal < 10; currentVal++) {
            // nowTotalVal = totalVal + currentVal
            int nowTotalVal = totalVal + currentVal;
        
            // if(targetVal < totalVal) return;
            if(targetVal < nowTotalVal) return;
            
            // if(visits[currentVal]) return;
            if(visits[currentVal]) continue;

            // visits[currentVal] = true;
            visits[currentVal] = true;

            // dfs(nowTotalVal, targetVal, visits, totalIndex, currentIndex + 1, list)
            dfs(nowTotalVal, currentVal, targetVal, totalIndex, currentIndex + 1, visits);

            // visits[currentVal] = false;
            visits[currentVal] = false;
        }
        
    }
}