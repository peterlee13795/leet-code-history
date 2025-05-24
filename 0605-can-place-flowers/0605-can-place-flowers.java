class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 반복문 (flowerbed)
        for(int i = 0, limit = flowerbed.length - 1; i <= limit; i++) {
            if(flowerbed[i] != 0) continue;

            // 왼쪽 empty 여부 (i == 0 || flowerbed[i-1] == 0)
            // 오른쪽 empty 여부 (i == len - 1 || flowerbed[i+1] == 0)
            boolean leftEmpty = i == 0 || flowerbed[i-1] == 0;
            boolean rightEmpty = i == limit || flowerbed[i+1] == 0;
            if(leftEmpty && rightEmpty) {
                // 왼쪽empty && 오른쪽empty
                // 심기 flowerbed[i] = 1
                // n--
                flowerbed[i] = 1;
                if(--n == 0) return true;
            }   
        }

        // 반복문 종료되면 n <= 0 여부 검증으로 return
        return n <= 0;
    }
}