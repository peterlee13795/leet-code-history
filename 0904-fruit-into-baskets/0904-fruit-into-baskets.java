class Solution {
    public int totalFruit(int[] fruits) {
        // 최대값, 길이
        int max = 0, len = fruits.length;
        
        // 투포인트 지정, lIndex, rIndex
        int lIndex = 0, rIndex = -1;
        
        // 트리 종류 count mapper
        Map<Integer, Integer> counts = new HashMap<>();
        
        // 반복문
        while(rIndex < len - 1) {
            
            rIndex++;
            
            Integer count = counts.get(fruits[rIndex]);
            if(count == null) { // 존재하지 않는 과일
                
                    while(counts.keySet().size() >= 2 && counts.get(fruits[lIndex]) != null) { // 존재하는 동안
                        int lFruitCount = counts.get(fruits[lIndex]);
                        if(lFruitCount == 1) {
                            counts.remove(fruits[lIndex]);
                        } else {
                            counts.put(fruits[lIndex], counts.get(fruits[lIndex]) - 1);    
                        }
                        lIndex++;
                    }
                
            }
        
            counts.put(fruits[rIndex], counts.getOrDefault(fruits[rIndex], 0) + 1);
            
            // max값 계산 (rIndex - lIndex + 1)
            max = Math.max(max, rIndex - lIndex + 1);
            
        }
    
        return max;
        
        
    }
}