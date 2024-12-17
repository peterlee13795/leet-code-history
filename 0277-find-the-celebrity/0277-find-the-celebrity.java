/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // list 반복하면서 counts[] == n인거 출력
        for (int i = 0; i < n; i++) {
            boolean found = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (!knows(j, i) || knows(i, j)) {
                    found = false;
                    break;
                }
            }
            if (found) return i;
        }

        return -1;
    }
}