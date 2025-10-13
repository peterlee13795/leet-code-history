class Solution {
    public String addBoldTag(String s, String[] words) {
    // 문자열 길이
    int len = s.length();

    // bold 여부 배열
    boolean[] isBold = new boolean[len];

    // words 반복문
    for (String word : words) {
      // word index 확인 반복문
      int index = s.indexOf(word);
      while (index != -1) {
        // index 찾은 경우, 선택 bold = true
        for (int bindex = index; bindex < index + word.length(); bindex++) {
          isBold[bindex] = true;
        }
        index = s.indexOf(word, index + 1);
      }
    }

    // bold 배열에 맞춰서 태그 붙이기
    StringBuilder stringBuilder = new StringBuilder();
    for (int index = 0; index < len; index++) {
      // bold tag추가
      if (isBold[index] && (index == 0 || !isBold[index - 1])) {
        stringBuilder.append("<b>");
      }
      stringBuilder.append(s.charAt(index));
      // bold tag제거
      if (isBold[index] && (index == len - 1 || !isBold[index + 1])) {
        stringBuilder.append("</b>");
      }
    }

    return stringBuilder.toString();
  }

}