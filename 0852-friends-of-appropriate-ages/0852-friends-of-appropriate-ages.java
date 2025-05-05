public class Solution {
    public int numFriendRequests(int[] ages) {
        int[] counts = new int[121];

        for (int age : ages) {
            counts[age]++;
        }

        int total = 0;
        for (int x = 1; x <= 120; x++) {
            if (counts[x] == 0) continue;

            // 정확히 조건 "age[B] > 0.5 * age[A] + 7"
            for (int y = (int)(x * 0.5 + 7) + 1; y <= x; y++) {
                if (counts[y] == 0) continue;

                if (x == y) {
                    total += counts[x] * (counts[x] - 1); // 자기 자신 제외
                } else {
                    total += counts[x] * counts[y];
                }
            }
        }

        return total;
    }
}
