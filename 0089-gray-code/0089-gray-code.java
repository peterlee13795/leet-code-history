class Solution {
    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<>();
        result.add(0);

        for(int i = 0; i < n; i++){
            List<Integer> reverses = new ArrayList<>(result);
            Collections.reverse(reverses);
            int power = (int) Math.pow(2, i); // 1,2,4,8
            for(int reverse: reverses) {
                result.add(power + reverse); // 1+0
            } // (0,1), 
        }
        
        return result;
    }
}