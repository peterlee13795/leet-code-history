class Solution {
    List<List<Integer>> answer;
    int size;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // init
        answer = new ArrayList<>();
        size = candidates.length;

        // sort
        Arrays.sort(candidates); // o(n*logn)

        // backtrack
        backtrack(candidates, target, new ArrayList<>(), 0, 0);

        // return list
        return answer;
    }

    private void backtrack(int[] candidates, int target, List<Integer> nodes, int sum, int start) {
        // iterate candidates => o(n * nodes.size)
        for(int i = start; i < size; i++) {
            int candidate = candidates[i];
            // add new num to sum
            int currentSum = sum + candidate;

            // if sum is larger than target => continue
            if(currentSum > target) return;
            else if (currentSum < target) {
                // // if smaller than sum => add to nodes and next backtrack
                nodes.add(candidate);
                backtrack(candidates, target, nodes, currentSum, i);
            } else {
                // if equals to target => add to answer and return
                nodes.add(candidate);
                answer.add(new ArrayList<>(nodes));
            }

            // // remove last node
            nodes.remove(nodes.size() - 1);
        }
    }
}