class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        // 이진탐색으로 시작 위치 찾기
        while (left < right) {
            int mid = (left + right) / 2;
            // x와 가까운 쪽을 선택
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // k개만큼 잘라서 반환
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
