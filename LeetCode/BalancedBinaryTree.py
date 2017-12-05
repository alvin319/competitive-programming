# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True
        left = self.getDepth(root.left)
        right = self.getDepth(root.right)
        if abs(left - right) <= 1:
            return self.isBalanced(root.left) and self.isBalanced(root.right)
        else:
            return False
    
    def getDepth(self, root):
        if root is None:
            return 0
        else:
            return max(self.getDepth(root.left), self.getDepth(root.right)) + 1
