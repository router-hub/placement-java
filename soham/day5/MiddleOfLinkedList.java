public class MiddleOfLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        public ListNode middleNode(ListNode head) {
            ListNode mid = head, end = head;
            while(end != null && end.next !=null ){
                end = end.next.next;
                mid = mid.next;
            }
            return mid;

        }

}
