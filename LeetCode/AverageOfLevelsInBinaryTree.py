# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque, defaultdict

class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        q = deque()
        if root:
            q.append((root, 0))
        m = defaultdict(list)
        max_level = 0
        
        while q:
            node, level = q.popleft()
            if node:
                m[level].append(node.val)
                max_level = max(max_level, level)
                if node.left:
                    q.append((node.left, level + 1))
                if node.right:
                    q.append((node.right, level + 1))
        
        answer = []
        for i in range(max_level + 1):
            answer.append(sum(m[i]) / float(len(m[i])))
        
        return answer
