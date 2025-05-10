class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lIndex = 0;
        int rIndex = numbers.length - 1;
        while(lIndex < rIndex) {
            int sum = numbers[lIndex] + numbers[rIndex];
            if(sum == target) {
                return new int[] {lIndex + 1, rIndex + 1};
            }
            if(sum < target) {
                lIndex++;
            } else {
                rIndex--;
            }
        }
        return new int[2];
    }
}