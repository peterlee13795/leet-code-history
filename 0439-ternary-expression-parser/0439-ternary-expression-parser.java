class Solution {
    public String parseTernary(String expression) {

    // 유효한 형태의 삼항연산자 검증 함수 반복문
    while (expression.length() > 1) {
      // 삼항연산자 포인터 지정
      int ternaryPointer = expression.length() - 1;
      // 일치하는게 나올 떄 까지 포인터 증분
      while (!isValidTernary(expression.substring(ternaryPointer - 4, ternaryPointer + 1))) {
        ternaryPointer--;
      }

      // expression 재정의
      char solvedTernary = solveTernary(expression.substring(ternaryPointer - 4, ternaryPointer + 1));
      expression = String.format("%s%s%s", expression.substring(0, ternaryPointer - 4), solvedTernary, expression.substring(ternaryPointer + 1));
    }

    return expression;
  }

  private char solveTernary(String ternary) {
    return ternary.charAt(0) == 'T' ? ternary.charAt(2) : ternary.charAt(4);
  }

  private boolean isValidTernary(String ternary) {

    return (ternary.charAt(0) == 'T' || ternary.charAt(0) == 'F') && ternary.charAt(1) == '?' && ternary.charAt(3) == ':';
  }
}