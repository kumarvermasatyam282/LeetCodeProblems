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
// class Solution {

//     public static ListNode reverseList(ListNode head) {
//         ListNode prev = null;
//         while (head != null) {
//             ListNode next = head.next;
//             head.next = prev;
//             prev = head;
//             head = next;
//         }
//         return prev;
//     }

//     public ListNode addTwoNumbers(ListNode t1, ListNode t2) {

         
//         // ListNode t1=reverseList(l1);
         
//         // ListNode t2=reverseList(l2);
    
//         ListNode dummy = new ListNode(-1);
//         ListNode curr = dummy;
//         int carry = 0;

//         while (t1 != null && t2 != null) {
//             int sum=t1.val+t2.val+carry;
//             carry = sum/10;
//             curr.next = new ListNode(sum % 10);
//             curr = curr.next;
//             t1=t1.next;
//             t2=t2.next;
//         }
        
//         while(t1!=null){
//            int sum = t1.val + carry;

//             curr.next = new ListNode(sum % 10);
//             curr = curr.next;

//             carry = sum / 10;

//             t1 = t1.next;
//         }

//         while(t2!=null){
//             int sum = t2.val + carry;

//             curr.next = new ListNode(sum % 10);
//             curr = curr.next;

//             carry = sum / 10;

//             t2 = t2.next;
//         }
//         if( carry!=0){
//             curr.next=new ListNode(carry);
//         }

//         return reverseList(dummy.next);
//     }
// }

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            carry = sum / 10;
        }

        return dummy.next;
    }
}