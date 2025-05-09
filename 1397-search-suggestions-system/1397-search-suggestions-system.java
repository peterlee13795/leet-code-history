class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Step 1: 정렬 (사전순 보장)
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();

        // Step 2: 검색 접두어를 점차 늘려가며 suggestions 저장
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;

            List<String> suggestions = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(prefix)) {
                    suggestions.add(product);
                    if (suggestions.size() == 3) break;
                }
            }

            result.add(suggestions);
        }

        return result;
    }

}