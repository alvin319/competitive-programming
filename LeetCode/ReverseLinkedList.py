# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        ans = []
        while head is not None:
            ans.append(head.val)
            head = head.next
        ans = ans[::-1]
        if len(ans) > 0:
            root = ListNode(ans[0])
            current = root
            if len(ans) > 1:
                for v in ans[1:]:
                    now = ListNode(v)
                    current.next = now
                    current = now
            return root
        else:
            return None