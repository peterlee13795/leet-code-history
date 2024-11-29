class Solution {
    public static String decodeString(String s) {
        // stack(string, number)
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();

        // current string, number
        StringBuilder stringCurrent = new StringBuilder();
        int currentNumber = 0;

        int len = s.length();

        // 반복문
        for(int i =0 ; i < len; i ++) {
            // each character
            char c0 = s.charAt(i);
            
            if(c0 == '[') { // open
                intStack.add(currentNumber);
                stringStack.add(stringCurrent.toString());
                currentNumber = 0;
                stringCurrent = new StringBuilder();
            } else if (c0 == ']') { // close
                StringBuilder stringClosed = new StringBuilder(stringStack.pop());
                int repeatCount = intStack.pop();
                
                for(int j = 0 ; j < repeatCount; j++) {
                    stringClosed.append(stringCurrent);
                }
                stringCurrent = stringClosed;
                
            } else if (Character.isDigit(c0)) { // number
                currentNumber = (currentNumber * 10) + (c0 - '0');
            } else { // normal character
                stringCurrent.append(c0);
            }
        }

        return stringCurrent.toString();
    }
}