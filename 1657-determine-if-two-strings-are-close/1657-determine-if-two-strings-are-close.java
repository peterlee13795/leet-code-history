class Solution {
    public boolean closeStrings(String word1, String word2) {
        // 조건1 길이 동일해야 함
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 != len2) return false;
        
        // 조건2 문자열 종류가 다르면 안됨
        Map<Character, Integer> counts1 = new HashMap<>();
        Map<Character, Integer> counts2 = new HashMap<>();
        for(int i =0 ; i < len1; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            counts1.put(c1, counts1.getOrDefault(c1, 0) + 1);
            counts2.put(c2, counts2.getOrDefault(c2, 0) + 1);
        }
        
        if(!counts1.keySet().equals(counts2.keySet())) return false;
        
        // 조건3 target의 종류 별 개수가 word1에 존재해야 함
        
        List<Integer> list1 = new ArrayList<>(counts1.values());
        List<Integer> list2 = new ArrayList<>(counts2.values());
        Collections.sort(list1);
        Collections.sort(list2);
        
        
        return list1.equals(list2);
    }
    
}