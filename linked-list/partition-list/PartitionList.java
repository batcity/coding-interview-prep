// https://leetcode.com/problems/partition-list/?envType=study-plan-v2&envId=top-interview-150


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
    public ListNode partition(ListNode head, int x) {

        ListNode before = null;
        ListNode after = null;

        ListNode currBefore = null;
        ListNode currAfter = null;

        while(head!=null) {

            if(head.val < x) {

                if(before == null) {
                    before = head;
                    currBefore = head;
                    before.next = null;
                } else {
                    currBefore.next = head;
                    currBefore = head;
                }
            } else {
                if(after == null) {
                    after = head;
                    currAfter = head;
                    after.next = null;
                } else {
                    currAfter.next = head;
                    currAfter = head;
                }
            }

            head = head.next;
        }

        if(before == null) {
            return after;
        }

        if(after!=null) {
            currBefore.next = after;
            return before;
        }

        return before;
    }
}