//Expression Add Operators

import java.util.*;
class Solution {
    private void backtrack(String num, int target, List<String> list, int idx, String current, long sum, long prev) {
    // Base case
    if (idx == num.length()) {
        if (target == sum) {
            list.add(current);
            return;
        }
    }

    for (int i = idx; i < num.length(); i++) {
        if (i != idx && num.charAt(idx) == '0') break;
        long cur = Long.parseLong(num.substring(idx, i + 1));
        if (idx == 0) {
            backtrack(num, target, list, i + 1, current + cur, cur, cur);
        } else {
            backtrack(num, target, list, i + 1, current + "+" + cur, sum + cur, cur);
            backtrack(num, target, list, i + 1, current + "-" + cur, sum - cur, -cur);
            backtrack(num, target, list, i + 1, current + "*" + cur, sum - prev + (prev * cur), prev * cur);
        }
    }
}
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        backtrack(num,target,list,0,"",0,0);
        return list;
    }
}