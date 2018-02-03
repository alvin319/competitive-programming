from collections import deque

class Solution:
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        front = []
        back = deque()
        
        current = 1
        for v in nums:
            current *= v
            front.append(current)
        current = 1
        for i in range(len(nums) - 1, -1, -1):
            current *= nums[i]
            back.appendleft(current)
        ans = []
        for i in range(len(nums)):
            first = front[i - 1] if i - 1 >= 0 else 1
            second = back[i + 1] if i + 1 < len(nums) else 1
            ans.append(first * second)
        
        return ans
