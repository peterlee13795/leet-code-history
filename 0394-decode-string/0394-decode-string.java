class Solution {
    public static String decodeString(String s) {
        // 스택 선언: 문자열과 숫자를 저장할 각각의 스택
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();

        // 현재 디코딩 중인 문자열과 숫자를 관리
        StringBuilder currentString = new StringBuilder();
        int currentNumber = 0;

        // 문자열의 각 문자를 하나씩 처리
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // 숫자일 경우: 자리 수를 고려해 숫자를 계산
                // 예: "12"는 '1'과 '2'를 연속적으로 처리해야 함
                currentNumber = currentNumber * 10 + (ch - '0');
            } else if (ch == '[') {
                // '['가 나오면 현재 문자열과 숫자를 스택에 저장
                // 중첩 처리를 위해 현재 상태를 보존
                stringStack.push(currentString.toString()); // 현재 문자열 저장
                numberStack.push(currentNumber);           // 반복 횟수 저장

                // 초기화: 다음 중첩 문자열을 처리하기 위해 리셋
                currentString = new StringBuilder();
                currentNumber = 0;
            } else if (ch == ']') {
                // ']'가 나오면 스택에서 이전 상태를 꺼내 현재 문자열을 디코딩
                StringBuilder decodedString = new StringBuilder(stringStack.pop()); // 이전 문자열
                int repeatCount = numberStack.pop();                               // 반복 횟수

                // 반복 횟수만큼 현재 문자열을 연결
                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currentString);
                }

                // 디코딩된 문자열을 현재 문자열로 설정
                currentString = decodedString;
            } else {
                // 일반 문자일 경우: 현재 문자열에 추가
                currentString.append(ch);
            }
        }

        // 최종 디코딩된 문자열 반환
        return currentString.toString();
    }
}