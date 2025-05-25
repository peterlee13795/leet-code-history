class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mappers = new HashMap<>();
        mappers.put('I', 1);
        mappers.put('V', 5);
        mappers.put('X', 10);
        mappers.put('L', 50);
        mappers.put('C', 100);
        mappers.put('D', 500);
        mappers.put('M', 1000);

        Set<Character> oneType = new HashSet<>(Arrays.asList('V', 'X'));
        Set<Character> tenType = new HashSet<>(Arrays.asList('L', 'C'));
        Set<Character> hunType = new HashSet<>(Arrays.asList('D', 'M'));
        int total = 0;

        for(int i = 0, limit = s.length() - 1 ; i <= limit; i++) {
            char c = s.charAt(i);
            int num = mappers.get(c);
            int multiply = 1;
            if(i < limit) {
                if(c == 'I' && oneType.contains(s.charAt(i + 1))) multiply = -1;
                else if(c == 'X' && tenType.contains(s.charAt(i + 1))) multiply = -1;
                else if(c == 'C' && hunType.contains(s.charAt(i + 1))) multiply = -1;
            }
            total += (multiply * num); 
        }
        return total;
    }
}