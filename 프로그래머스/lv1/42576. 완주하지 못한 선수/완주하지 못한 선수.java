import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(completion);
        Arrays.sort(participant);
        Queue<String> q = new LinkedList<>(Arrays.asList(completion));
        LinkedList<String> arr = new LinkedList<>(Arrays.asList(participant));
        
        while(!q.isEmpty()) {
            String cur = q.poll();
            
            if (arr.get(0).equals(cur)) {
                arr.remove(0);
            } else {
                return arr.get(0);
            }
        }
        
        return arr.get(0);
    }
}