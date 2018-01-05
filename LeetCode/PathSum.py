# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque

class Solution:
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        q = deque()
        if root is not None:
            q.append((root, root.val))
        
        while q:
            node, total = q.popleft()
            if total == sum and node.left is None and node.right is None:
                return True
            if node:
                if node.left:
                    q.append((node.left, total + node.left.val))
                if node.right:
                    q.append((node.right, total + node.right.val))
        
        return False