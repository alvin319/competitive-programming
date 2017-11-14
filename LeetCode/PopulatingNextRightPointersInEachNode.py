# Definition for binary tree with next pointer.
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        self.assign_node(root)
    
    def assign_node(self, root):
        if root is not None:
            if root.left is not None and root.right is not None:
                root.left.next = root.right
            if root.right is not None:
                root.right.next = self.get_val(root.next)
            self.assign_node(root.left)
            self.assign_node(root.right)
    
    def get_val(self, root):
        if root is not None:
            if root.left is not None:
                return root.left
            if root.right is not None:
                return root.right
        return None