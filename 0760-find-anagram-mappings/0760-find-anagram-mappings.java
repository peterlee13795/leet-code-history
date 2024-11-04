class Solution {
  public int[] anagramMappings(int[] nums1, int[] nums2) {
    int len = nums1.length;
    Map<Integer, List<Integer>> indexMapping = new HashMap<>(); // <num2, num2-인덱스-리스트> 매핑 객체 선언
    for (int i = 0; i < len; i++) { // nums2 배열 순회, <num2: list<index>>
      int num2 = nums2[i];
      List<Integer> indexes = indexMapping.computeIfAbsent(num2, k -> new ArrayList<>());
      indexes.add(i);
    }
    int[] answer = new int[len]; // 답안 선언 (nums1와 동일 사이즈 배열)
    for (int i = 0; i < len; i++) { //
      int num1 = nums1[i]; // num1 값
      List<Integer> indexes = indexMapping.get(num1); // num1 값을 통해 num2 인덱스 리스트
      answer[i] = indexes.get(0); // 최초 인덱스 추출 및 제거
      indexes.remove(0);
    }
    return answer;
  }
}