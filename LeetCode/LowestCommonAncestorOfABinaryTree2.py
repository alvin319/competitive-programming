from collections import deque

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        queue = deque()
        queue.append((root, []))
        p_path = None
        q_path = None
        
        while len(queue) > 0:
            node, path = queue.popleft()
            if p_path is not None and q_path is not None:
                break
            if node is not None:
                if node.val == p.val:
                    p_path = path + [node]
                elif node.val == q.val:
                    q_path = path + [node]
                queue.append((node.left, path + [node]))
                queue.append((node.right, path + [node]))
        
        if p_path is not None and q_path is not None:
            p_path = set([v.val for v in p_path])
            for i in range(len(q_path) - 1, -1, -1):
                if q_path[i].val in p_path:
                    return q_path[i]