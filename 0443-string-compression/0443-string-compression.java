class Solution {
    public static int compress(char[] chars) {
        int write = 0, read = 0;
        
        int len = chars.length;
        if(len <= 1) return len;
        
        while(read < len) {
            char currentChar = chars[read];
            int count = 0;
            
            while(read < len && chars[read] == currentChar) {
                count++;
                read++;
            }
            
            chars[write++] = currentChar;
            if(count == 1) continue;
            
            char[] nums = String.valueOf(count).toCharArray();
            for(char num: nums) {
                chars[write++] = num;
            }
        }
        
        return write;
    }
}