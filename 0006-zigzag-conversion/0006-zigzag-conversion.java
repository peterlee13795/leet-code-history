class Solution {
    public String convert(String s, int numRows) {
    if(numRows == 1) {
      return s;
    }
    // len
    int len = s.length();

    // stringBuilder
    StringBuilder stringBuilder = new StringBuilder();

    // iterate char

    for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
      // jumpNo = 2 * (rowNumber - i) - 2
      boolean first = rowIndex == 0;
      boolean last = rowIndex == numRows - 1;
      boolean middle = !first && !last;
      int cursor = rowIndex;
      int cursorIndex = 0;
      while (cursor < len) {
        stringBuilder.append(s.charAt(cursor));

        boolean odd = cursorIndex % 2 == 1;
        boolean below = first || (middle && !odd);
        // 2 * (rowNumber - i - 1) : 2 * i
        int jumpNo = below ? 2 * (numRows - rowIndex - 1) : 2 * rowIndex;
        cursor += jumpNo;
        cursorIndex++;

      }
    }

    return stringBuilder.toString();
  }
}