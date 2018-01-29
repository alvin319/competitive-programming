# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque, defaultdict

class Solution:
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        
        m = defaultdict(list)
        q = deque()
        q.append((root, 0))
        level = 0
        
        while len(q) > 0:
            node, value = q.popleft()
            if node is not None:
                m[value].append(node.val)
                level = max(level, value)
                q.append((node.left, value + 1))
                q.append((node.right, value + 1))
        
        ans = []
        for i in range(level, -1, -1):
            ans.append(m[i])
        
        return ans