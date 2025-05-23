class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // len
        int glen = g.length;
        int slen = s.length;

        // sort greedy
        Arrays.sort(g);

        // sort cookie size
        Arrays.sort(s);

        int count = 0;

        // two-pointer iterate
        int gidx = 0;
        int sidx = 0;
        while(gidx < glen && sidx < slen) {
            while(gidx < glen && sidx < slen && g[gidx] <= s[sidx]) {
                count++;
                gidx++;
                sidx++;
            }
            sidx++;
        }
        
        // if greedy is not enough -> break
        // if size is not enough sizeIndex++

        // return max;
        return count;
    }
}