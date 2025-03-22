class Solution {
    public String intToRoman(int num) {
        // StringBuilder
        StringBuilder stringBuilder = new StringBuilder();

        // pairs, 1000 -> M ..
        Map<Integer, String> pairs = new HashMap<>();
        pairs.put(1000, "M");
        pairs.put(900, "CM");
        pairs.put(500, "D");
        pairs.put(400, "CD");
        pairs.put(100, "C");
        pairs.put(90, "XC");
        pairs.put(50, "L");
        pairs.put(40, "XL");
        pairs.put(10, "X");
        pairs.put(9, "IX");
        pairs.put(5, "V");
        pairs.put(4, "IV");
        pairs.put(1, "I");

        // iterate from 1000 to ..
        List<Integer> keys = pairs.keySet().stream().sorted((a, b) -> b - a).toList();
        for(Integer key: keys) {
            // if ( > 0 ? ) append StringBuilder
            int div = num / key;
            if(div > 0) {
                String c0 = pairs.get(key);
                for(int i = 0 ; i < div ; i ++) {
                    stringBuilder.append(c0);
                }
                num %= key;
            }
        }
        // return
        return stringBuilder.toString();
    }
}