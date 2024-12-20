/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        // StringBuilder
        StringBuilder builder = new StringBuilder();
        
        // iterate startUrl and find third slash to extract hostname
        for(int i =0, len = startUrl.length(), count = 0; i < len; i++) {
            char curr = startUrl.charAt(i);
            if(curr == '/') {
                if(++count == 3) {
                    break;
                }
            }
            builder.append(curr);
        }
        // get target urls
        String hostname = builder.toString();
        
        // define set to prevent duplication
        Set<String> sets = new HashSet<>();
        sets.add(startUrl);
        
        
        // iterate target urls
        
        Stack<String> stack = new Stack<>();
        stack.add(startUrl);
        sets.add(startUrl);
        while(!stack.isEmpty()) {
            String currUrl = stack.pop();
            
            List<String> nextUrls = htmlParser.getUrls(currUrl);  
            for(String nextUrl: nextUrls) {
                // add to set if not contains in set
                if(sets.contains(nextUrl)) continue;
                if(!nextUrl.startsWith(hostname)) continue;
                sets.add(nextUrl);
                stack.add(nextUrl);    
            }
        }
        
        
        // return as list
        return new ArrayList<>(sets);
    }
}