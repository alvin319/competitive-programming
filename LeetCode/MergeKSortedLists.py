# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from heapq import heappush, heappop

class Solution(object):        
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        ans = []
        for node in lists:
            while node:
                heappush(ans, node.val)
                node = node.next
        root_node = ListNode(heappop(ans)) if len(ans) > 0 else None
        current_node = root_node
        while ans:
            current_node.next = ListNode(heappop(ans))
            current_node = current_node.next
        return root_node