# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque, defaultdict

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        queue = deque()
        queue.append((root, 0))
        m = defaultdict(list)
        while len(queue) > 0:
            node, level = queue.popleft()
            if node is not None:
                m[level].append(node.val)
                if node.left is not None:
                    queue.append((node.left, level + 1))
                if node.right is not None:
                    queue.append((node.right, level + 1))
        answer = []
        for k in sorted(m.keys()):
            answer.append(m[k])
        
        return answer
 