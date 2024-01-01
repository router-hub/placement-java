
class Solution {
    public ListNode findKthNode(ListNode head, int k) {
        while (head != null && (k)-- > 1) {
            head = head.next;
        }
        return head;
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                    break;
                } 
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            // Update the head of the reversed sublist
            ListNode newHead = reverseLinkedList(temp);

            if (temp == head) {
                head = newHead;
            } else {
                prevLast.next = newHead;
            }

            prevLast = temp;
            temp = nextNode;
        }

        return head;
    }
}
