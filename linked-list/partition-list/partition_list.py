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

        root = head

        while(root is not None):

            print("entering the loop")

            if root.val < x:
                firstHalfNode.next = root
                firstHalfNode = firstHalfNode.next
            else:
                secondHalfNode.next = root
                secondHalfNode = secondHalfNode.next

            root = root.next

        firstHalfNode.next = secondHalfRoot.next

        return firstHalfRoot.next
