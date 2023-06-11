import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int half = nums.length / 2;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int count = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            it.next();
            count++;
        }
        
        if (count >= half) {
            return half;
        } else {
            return count;
        }
    }
}