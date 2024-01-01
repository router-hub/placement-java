public class Ques01 {
    public ListNode reverse(ListNode head)
    {
        if(head==null || head.next==null)return head;
        ListNode pre=null,curr=head,next=head.next;
        while(next!=null)
        {
            curr.next=pre;
            pre=curr;
            curr=next;
            next=next.next;
        }
        curr.next=pre;
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        while(cur!=null)
        {
            ListNode temp=cur;//pre list node last pointer
            for(int i=0;i<k;i++)
            {
                temp=temp.next;
                if(temp==null)return dummy.next;
            }
            ListNode nextFirst=temp.next;
            ListNode last=cur.next;
            temp.next=null;
            cur.next=reverse(cur);
            last.next=nextFirst;
            cur=last;

        }
        return dummy.next;
    }
}
