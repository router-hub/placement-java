//insertion sort list

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode current = head;

        while (current != null) {

            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            ListNode next = current.next;

            current.next = prev.next;
            prev.next = current;

            current = next;
        }
        return dummy.next;
    }
}