class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        total = 0
        start_index = 0
        end_index = 0
        best_total = 0
        
        is_neg = all(x < 0 for x in nums)
        if is_neg:
            return max(nums)
            
        for i, v in enumerate(nums):
            total += v
            end_index = i
            if total > best_total:
                best_total = total
            if total < 0:
                total = 0
                start_index = i
        
        return best_total