import java.util.*;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists== null || lists.length==0){
            return null;

        }

        ListNode start = new ListNode(-1);
        ListNode temp = start;
        ArrayList<Integer> l = new ArrayList<>();

        for(ListNode list : lists){
            while(list!=null){
                l.add(list.val);
                list = list.next;
            }

        }

        Collections.sort(l);
        for(int i : l){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        return start.next;
    }
}
