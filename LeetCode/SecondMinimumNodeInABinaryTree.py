from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findSecondMinimumValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        s = set()
        q = deque()
        q.append(root)
        
        while q:
            state = q.popleft()
            if state:
                s.add(state.val)
            if state.left:
                q.append(state.left)
            if state.right:
                q.append(state.right)
        
        if len(s) < 2:
            return -1
        return sorted(list(s))[1]
