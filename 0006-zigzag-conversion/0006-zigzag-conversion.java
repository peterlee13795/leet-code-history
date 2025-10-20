class Solution {
    int len = 0;
    public String convert(String s, int numRows) {
        // 예외처리 (numRows == 1 || s.length() <= numRows)
        if(numRows  == 1 || s.length() <= numRows) {
            return s;
        }

        // StringBuilder 각 라인 별 배열 생성
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i =0 ; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        boolean goingUp = false;
        int currentRow = 0;
        int len = s.length();

        // s 문자열 반복문
        for(char c: s.toCharArray()) {
            // 현재 행 위치 찾아서 append
            sb[currentRow].append(c);

            // up 이나 down에 따라 행 위치 변경
            if(currentRow == 0) goingUp = false;
            else if (currentRow == numRows - 1) goingUp = true;
            currentRow += (goingUp ? -1 : 1);
        }

        StringBuilder concat = new StringBuilder();
        for(int i =0 ; i < numRows; i++) {
            concat.append(sb[i].toString());
        }

        // return 
        return concat.toString();
        
    }
}