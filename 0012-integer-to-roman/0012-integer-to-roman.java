class Solution {
    public String intToRoman(int num) {
        // int[]
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        // char[]
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        

        // answer string
        StringBuilder sb = new StringBuilder();

        // iterate num
        for(int i = 0, len = values.length; i < len; i++) {
            // while if current num is bigger than
            while(num >= values[i]) {
                // if smaller append and substract
                sb.append(romans[i]);
                num -= values[i];
            }
        }

        // return
        return sb.toString();
    }
}