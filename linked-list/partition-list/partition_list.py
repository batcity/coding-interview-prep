# Time complexity: O(N) where N is the number of nodes in the original list
# Space complexity: O(1), this solution doesn't use any additional space

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: ListNode | None, x: int) -> ListNode | None:

        firstHalfRoot = ListNode()
        secondHalfRoot = ListNode()

        firstHalfNode = firstHalfRoot
        secondHalfNode = secondHalfRoot

        while(head is not None):

            if head.val < x:
                firstHalfNode.next = head
                firstHalfNode = firstHalfNode.next
            else:
                secondHalfNode.next = head
                secondHalfNode = secondHalfNode.next

            head = head.next

        secondHalfNode.next = None
        firstHalfNode.next = secondHalfRoot.next

        return firstHalfRoot.next
