class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode current = head;

        ArrayList <Integer> list = new ArrayList<>();

        while(current != null){
            list.add(current.val);
            current = current.next;
        }

        Collections.sort(list);
        current = head;
        int j = 0;

        while(current != null && j<list.size()){
            current.val = list.get(j);
            j++;
            current = current.next;
        }
         return head;
    }
}
