class Solution {
    public int maxArea(int[] height) {
        int max = 0;
    int lIndex = 0;
    int rIndex = height.length - 1;
    
    while(lIndex < rIndex) {
      int l = rIndex - lIndex;
      int h = Math.min(height[rIndex], height[lIndex]);
      max = Math.max(max, l * h);
      if(height[rIndex] > height[lIndex]) lIndex++;
      else rIndex--;
    }
    
    return max;
    }
}