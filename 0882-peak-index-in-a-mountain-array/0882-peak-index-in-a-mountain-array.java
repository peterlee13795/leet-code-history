class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // left, right 초기화
        int limit = arr.length - 1;
        int left = 0;
        int right = limit;
        

        // 이진트리
        while(left <= right) {
            // mid 찾기
            int mid = left + (right - left) / 2;

            if(mid == 0) return 1;
            if(mid == limit) return limit;
            


            // mid가 왼쪽, 오른쪽보다 크다면 정답
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            // mid가 왼쪽보다 작다면, right = mid - 1
            else if (arr[mid] < arr[mid - 1]) right = mid - 1;
            // mid가 오른쪽보다 작다면 left = mid + 1;
            else left = mid + 1;
        }

        // 찾을 수 없음
        return -1;
    }
}