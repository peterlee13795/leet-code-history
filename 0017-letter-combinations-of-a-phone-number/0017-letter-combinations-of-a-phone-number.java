class Solution {
    int len;
    Map<Integer, List<Character>> mapper = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        mapper.put(1, Arrays.asList());
        mapper.put(2, Arrays.asList('a', 'b', 'c'));
        mapper.put(3, Arrays.asList('d', 'e', 'f'));
        mapper.put(4, Arrays.asList('g', 'h', 'i'));
        mapper.put(5, Arrays.asList('j', 'k', 'l'));
        mapper.put(6, Arrays.asList('m', 'n', 'o'));
        mapper.put(7, Arrays.asList('p', 'q', 'r', 's'));
        mapper.put(8, Arrays.asList('t', 'u', 'v'));
        mapper.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        this.len = digits.length();
        if(len == 0) return result;
        for(int i = 0; i < len ; i ++) {
            nums.add(digits.charAt(i) - '0');
        }
        backtracking(nums, 0, result, "");

        return result;
    }

    void backtracking(List<Integer> digits, int index, List<String> result, String curr) {
        Map<Integer, List<Character>> mapper = this.mapper;
        boolean last = index == len - 1;
        for(Character target: mapper.get(digits.get(index))) {
            String next = curr + target;
            if(last) result.add(next);
            else backtracking(digits, index + 1, result, next);
        }
    }
}