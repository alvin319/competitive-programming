# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        queue = deque()
        queue.append((root, 0))
        answer = 0
        starting = set()
        starting.add(root)
        while len(queue) > 0:
            node, current = queue.popleft()
            if node is not None:
                current += node.val
                if current == sum:
                    answer += 1
                queue.append((node.left, current))
                queue.append((node.right, current))
                if node.left not in starting:
                    queue.appendleft((node.left, 0))
                    starting.add(node.left)
                if node.right not in starting:
                    queue.appendleft((node.right, 0))
                    starting.add(node.right)
        
        return answer
