# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

cache = {}

class Solution(object):
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.helper(root, 0, False)
    
    def helper(self, node, total, choice):
        if (node, total, choice) in cache:
            return cache[(node, total, choice)]
        if node:
            v = node.val
            if choice:
                a = self.helper(node.left, 0, False)
                b = self.helper(node.right, total, False)
                cache[(node, total, choice)] = a + b
                return a + b
            else:
                c = self.helper(node.left, total + v, True)
                d = self.helper(node.right, 0, True)
                e = self.helper(node.left, total, False)
                f = self.helper(node.right, 0, False)
                cache[(node, total, choice)] = max(c + d, e + f)
                return max(c + d, e + f)
        else:
            return total
