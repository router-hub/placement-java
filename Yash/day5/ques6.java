import java.util.*;
class Solution {
    public ListNode midNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode mid = slow.next;
        slow.next = null;

        return mid;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode start = new ListNode(-1);
        ListNode k = start;

        while(l1!=null && l2!= null){
            if(l1.val <= l2.val){
                 k.next = l1;
                 l1 = l1.next;
                 
            }
            else{
                k.next = l2;
                l2 = l2.next;
                
            }
            k = k.next;
        }

        k.next = l1!=null ? l1 : l2 ; 



        return start.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode mid = midNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
}