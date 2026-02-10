  //25. Reverse Nodes in k-Group
  
  
  class Solution {

    // get kth node from current position
    ListNode KNodes(ListNode head, int k) {
        while (head != null && k-- > 1) {
            head = head.next;
        }
        return head;
    }

    // reverse a linked list
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;

        ListNode temp = head;
        ListNode prevTail = null;

        while (temp != null) {
            ListNode kthNode = KNodes(temp, k);
            if (kthNode == null) {
                if(prevTail!= null) prevTail.next=temp;
                 break;
            }

            ListNode nextGroup = kthNode.next;
            kthNode.next = null;

            ListNode newHead = reverse(temp);

            if (temp == head) {
                head = newHead;
            } else {
                prevTail.next = newHead;
            }

            prevTail = temp;   // temp is tail after reversal
            temp = nextGroup;
        }



        return head;
    }
}

