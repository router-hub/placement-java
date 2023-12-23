//Merge k Sorted List

class Solution {
    private ListNode merge(ListNode[] lists, int l, int r) {
        if (r < l) return null;
        if (r == l) return lists[r];
        
        int mid = (l + r) / 2;
        ListNode a = merge(lists, l, mid);
        ListNode b = merge(lists, mid + 1, r);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (a != null && b != null) {
            if (a.val < b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }
        current.next = (a != null) ? a : b;
        
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    
}