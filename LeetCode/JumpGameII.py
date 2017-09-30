from collections import deque

class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return 0
        
        index = 0
        max_range = nums[index]
        count = 1
        
        while True:
            if max_range >= len(nums) - 1:
                return count
            
            best_range = max_range
            best_index = -1
            
            for i in range(index, max_range + 1):
                if i < len(nums) and i + nums[i] > best_range:
                    best_range = i + nums[i]
                    best_index = i
            
            max_range = best_range
            index = i
            count += 1
            
        return count
