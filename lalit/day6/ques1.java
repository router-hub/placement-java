//Reverse nodes in K-Groupes

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            curr = reverseKGroup(curr, k);

            while (count > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
                count--;
            }
            head = curr;
        }
        return head;
    }
}
