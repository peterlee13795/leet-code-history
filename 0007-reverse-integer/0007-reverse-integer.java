class Solution {
    public int reverse(int x) {
        String s = String.valueOf(x);
        int multiply = 1;
        int start = 0;
        if(s.charAt(0) == '-') {
            multiply = -1;
            start = 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int len = s.length(), i = len - 1; i >= start; i--) {
            sb.append(s.charAt(i));
        }

        Long val = Long.parseLong(sb.toString()) * multiply;

        if(val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) return 0;
        return val.intValue();
    }
}