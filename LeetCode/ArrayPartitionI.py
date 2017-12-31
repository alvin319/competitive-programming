class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums)
        total = 0
        
        for i in range(0, len(nums) - 1, 2):
            total += min(nums[i], nums[i + 1])
        
        return total
