class Solution {
    public int countLetters(String s) {
        int count = 0;
        int same = 0;
        char b = '-';
        for(char v: s.toCharArray()) {
            if(b == v) {
                same++;
            } else {
                same = 1;
                b = v;
            }
            count += same;
        }
        return count;
    }
}