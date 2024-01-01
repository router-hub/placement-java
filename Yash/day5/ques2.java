import java.util.*;

public class Solution {

    public int getLength(ListNode head){
        ListNode temp = head;
        int size=1;

        while(temp!=null){
            temp = temp.next;
            size++;
        }

        return size;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = getLength(headA);
        int lb = getLength(headB);

        while(la > lb){
            la--;
            headA = headA.next;

        }

        while(lb > la){
            lb--;
            headB = headB.next;
        }

        while(headA!= headB){
            headA= headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
