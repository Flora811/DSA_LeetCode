/**
 * Definition for singly-linked list.
 * 
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(lists == null || n == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i=0; i<n; i++){
            if(lists[i]!=null)
                pq.add(lists[i]);
        }

        ListNode t = new ListNode(-1);
        ListNode temp = t;
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            temp.next = new ListNode(curr.val);
            if(curr.next != null)
                pq.add(curr.next);
            temp = temp.next;
        }

        return t.next;
    }
}