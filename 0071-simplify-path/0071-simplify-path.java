class Solution {
    public String simplifyPath(String path) {
        // init , answer list
        List<String> answer = new ArrayList<>();

        // split by "/", iterate
        for(String each: path.split("/")) {
            // if(. || empty) continue
            if(each.isEmpty() || ".".equals(each)) continue;

            // if(..) pop last element
            boolean before = "..".equals(each);
            if(answer.size() > 0 && before) {
                answer.remove(answer.size() - 1);
            } else if(!before) {
                answer.add(each);
            }
        }
        return "/%s".formatted(String.join("/", answer));
    }
}