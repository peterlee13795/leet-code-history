public class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121]; // 나이 범위 1~120

        for (int age : ages) count[age]++;

        int total = 0;

        for (int ageA = 15; ageA <= 120; ageA++) {
            if (count[ageA] == 0) continue;

            for (int ageB = 15; ageB <= 120; ageB++) {
                if (count[ageB] == 0) continue;

                if (ageB <= ageA * 0.5 + 7) continue;
                if (ageB > ageA) continue;
                if (ageB > 100 && ageA < 100) continue; // 추가된 조건!

                if (ageA == ageB) {
                    total += count[ageA] * (count[ageA] - 1); // 자기 자신 제외
                } else {
                    total += count[ageA] * count[ageB];
                }
            }
        }

        return total;
    }
}
