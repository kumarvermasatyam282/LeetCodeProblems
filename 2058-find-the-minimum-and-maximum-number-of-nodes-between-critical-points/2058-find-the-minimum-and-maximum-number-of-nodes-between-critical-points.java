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
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        ListNode t1=head;
        ListNode t2=head.next.next;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int current=0; 
        int first=-1;
        int prev=-1;
         
        while(t2!=null){
            if(t1.val < t1.next.val && t1.next.val>t2.val || 
            t1.val > t1.next.val && t1.next.val < t2.val){ 
                if (first==-1){
                    first=current;
                }
                 if (prev != -1) {
                    min = Math.min(min, current - prev);
                    max = Math.max(max, current - first);
                }
                prev=current;
            }
            t1 = t1.next;
            t2 = t2.next;
            current++;
             
        }
        if (prev == first) {
            return new int[]{-1, -1};
        }
        int[] arr={min,max};
        return arr;
    }
}