//Palindrome Linked List

class Solution {
    public ListNode findMiddle(ListNode head){
        ListNode hare = head;
        ListNode turtle = head;

        while(hare.next != null && hare.next.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode firstHalfStart = head;
        ListNode middle = findMiddle(head);
        ListNode secondHalfStart = reverse(middle.next);

        while(secondHalfStart != null){
        if(firstHalfStart.val != secondHalfStart.val){
                return false;
        }
        firstHalfStart = firstHalfStart.next;
        secondHalfStart = secondHalfStart.next;
        }
        return true;
    }
}