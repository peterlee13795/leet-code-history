class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // map type key: sorted_string, value: list<String>
        Map<String, List<String>> mappers = new HashMap<>();
        
        // iterate strs
        for(String str: strs) {
            // sort and put to map
            mappers.computeIfAbsent(sort(str), str0 -> new ArrayList<>()).add(str);
        }

        List<List<String>> answer = new ArrayList<>();
        for(List<String> value: mappers.values()) {
            answer.add(value);
        }
        
        
        // return answer
        return answer;
    }
    
    
    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}