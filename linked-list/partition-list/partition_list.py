# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
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
                firstHalfNode.next = ListNode(head.val, head.next)
                firstHalfNode = firstHalfNode.next
            else:
                secondHalfNode.next = ListNode(head.val, head.next)
                secondHalfNode = secondHalfNode.next

            head = head.next

        firstHalfNode.next = secondHalfRoot.next

        return firstHalfRoot.next
