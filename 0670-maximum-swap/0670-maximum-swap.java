class Solution {
    public int maximumSwap(int num) {
        // init (characters, 마지막 위치)
        char[] digits = String.valueOf(num).toCharArray();
        int len = digits.length;

        // 마지막 수 위치
        int[] last = new int[10];
        for(int i =0 ; i < len; i++) last[digits[i] - '0'] = i;

        for(int i = 0; i < len; i++) {
            int digit = digits[i] - '0';
            for(int d = 9; d > digit; d--) {
                if(last[d] > i) {
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        // 9~0 반복문 처리

        return num;
    }
}