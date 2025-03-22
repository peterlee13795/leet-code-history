class Solution {
    public boolean isPalindrome(int x) {
        String val = String.valueOf(x);
        for(int i = 0, len = val.length() ; i < len; i++) {
            char l = val.charAt(i);
            char r = val.charAt(len - i - 1);
            if(l != r) return false;
            
        }
        return true;
    }
}