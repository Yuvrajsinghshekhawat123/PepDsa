// 328. Odd Even Linked List


//Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy=new ListNode(-1);
         ListNode dummy1=new ListNode(-1);
        
        ListNode temp=dummy;
        ListNode temp1=dummy1;

        ListNode curr=head;
        int len=0;

        while(curr!=null){
            len++;
            curr=curr.next;
        }

        curr=head;

        for(int i=0;i<len;i++){
            if(i%2==0){
                temp.next=curr;
                temp=temp.next;
            }else{
                temp1.next=curr;
                temp1=temp1.next;
            }
            curr=curr.next;
        }

        temp.next=null;
        temp1.next=null;
        temp.next=dummy1.next;


        return dummy.next;
    }
}