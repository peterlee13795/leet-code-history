class Solution {
    public boolean validPalindrome(String s) {
        // iterate string
        int left = 0;
        int right = s.length() - 1;

        // check left and right
        while(left <= right) {
            // if not eqauls check both side
            if(s.charAt(left) != s.charAt(right)) {
                return isPalindrom(s, left +1, right) || isPalindrom(s, left, right - 1);
            }
            left++;
            right--;
        }

        // return true
        return true;
    }

    boolean isPalindrom(String s, int left, int right) {
        // left and right check
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }
}