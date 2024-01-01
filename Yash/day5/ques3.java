import java.util.*;
class Solution {

    public ListNode reverseLL(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }

        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = reverseLL(slow);
        ListNode left = head;

        while(right!=null){
            if(right.val == left.val){
                left = left.next;
                right = right.next;
            }
            else{
                return false;
            }
        }

        return true;


    }
}