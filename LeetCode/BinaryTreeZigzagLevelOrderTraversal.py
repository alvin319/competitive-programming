# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque, defaultdict

class Solution:
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        q = deque()
        q.append((root, 0))
        layers = defaultdict(list)
        max_level = -1
        
        while q:
            state, level = q.popleft()
            if state:
                max_level = max(max_level, level)
                layers[level].append(state.val)
                if state.left:
                    q.append((state.left, level + 1))
                if state.right:
                    q.append((state.right, level + 1))
        
        answer = []
        for i in range(max_level + 1):
            if i % 2 == 0:
                answer.append(layers[i])
            else:
                answer.append(list(reversed(layers[i])))
        
        return answer
