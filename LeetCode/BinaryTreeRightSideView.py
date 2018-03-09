# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque, defaultdict

class Solution:
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        q = deque()
        ans = defaultdict(list)
        q.append((root, 0))
        
        while len(q) > 0:
            state, level = q.popleft()
            if state is not None:
                ans[level].append(state.val)
                if state.left is not None:
                    q.append((state.left, level + 1))
                if state.right is not None:
                    q.append((state.right, level + 1))
        
        answer = []
        for i in range(len(ans)):
            answer.append(ans[i][-1])
            
        return answer
