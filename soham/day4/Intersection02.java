public class Intersection02 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            Set<ListNode> nodeSet = new HashSet<>();


            ListNode nodeA = headA;
            while (nodeA != null) {
                nodeSet.add(nodeA);
                nodeA = nodeA.next;
            }


            ListNode nodeB = headB;
            while (nodeB != null) {
                if (nodeSet.contains(nodeB)) {
                    return nodeB;
                }
                nodeB = nodeB.next;
            }

            return null;
        }

}
