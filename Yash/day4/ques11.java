import java.util.*;
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode next;
        ListNode curr= head;
        ListNode prev = null;

        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}