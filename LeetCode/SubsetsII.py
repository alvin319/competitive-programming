from collections import deque

class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        q = deque()
        q.append(([], 0))
        s = []
        cache = set()
        
        while q:
            current, index = q.popleft()
            current = sorted(current)
            if index == len(nums):
                if tuple(current) not in cache:
                    cache.add(tuple(current))
                    s.append(current)
            else:
                q.append((current + [nums[index]], index + 1))
                q.append((current, index + 1))
        
        return s
