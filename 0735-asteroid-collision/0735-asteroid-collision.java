import java.util.stream.Stream;
import java.util.*;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> positives = new Stack<>();
        List<Integer> remains = new ArrayList<>();
        
        for(int item: asteroids) {
            // if negative
            if(item > 0) positives.add(item);
            else {
                boolean isExplode = false;
                while(!positives.isEmpty()) {
                    int result = positives.peek() + item;
                    if(result > 0) {
                        isExplode = true;
                    } else if (result == 0) {
                        positives.pop();
                        isExplode = true;
                    } else {
                        positives.pop();
                    }
                    if(isExplode) break;
                }
                if(positives.isEmpty() && !isExplode) {
                    remains.add(item);
                }
            }
        }
        
        remains.addAll(positives);
        
        return remains.stream().mapToInt(i -> i).toArray();
    }
}