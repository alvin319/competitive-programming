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
        if p == q:
            return root
        p_result, q_result = self.getPath(root, p, q)
        p_index, q_index = 0, 0
        ans_index = -1
        while p_index < len(p_result) and q_index < len(q_result):
            if p_result[p_index] == q_result[q_index]:
                ans_index = p_index
                p_index += 1
                q_index += 1
            else:
                break
        return p_result[ans_index] if ans_index != -1 else root
    
    def getPath(self, root, target, target_2):
        q = deque()
        q.append((root, [root]))
        ans_path1 = None
        ans_path2 = None
        
        while q is not None:
            node, path = q.popleft()
            if node is not None:
                if node == target:
                    ans_path1 = path
                elif node == target_2:
                    ans_path2 = path
                q.append((node.left, path + [node.left]))
                q.append((node.right, path + [node.right]))
            if ans_path1 is not None and ans_path2 is not None:
                break
        
        return ans_path1, ans_path2
        