/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
    // init (나를 알고있음-개수: int[], 내가 다른 사람을 1명이라도 알고있음: boolean[])
    int[] otherKnowsMeCount = new int[n];
    boolean[] knowAnyone = new boolean[n];

    // 1~n  2중 반복
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        boolean know = knows(i, j); // i가 j를 알고 있음
        if (know && i != j) {
          otherKnowsMeCount[j]++;
          knowAnyone[i] = true;
        }
      }
    }

    // n 반복
    for(int i= 0 ; i < n ; i++) {
      boolean isCelebrity = otherKnowsMeCount[i] == n - 1 && !knowAnyone[i];
      if(isCelebrity) {
        return i;
      }
    }

    // return -1
    return -1;
  }
}