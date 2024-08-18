package neetcode;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
