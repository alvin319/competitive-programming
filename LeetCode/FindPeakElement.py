class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for i in range(len(nums)):
            if i < len(nums):
                prev_value = nums[i - 1] if i - 1 >= 0 else float('-inf')
                next_value = nums[i + 1] if i + 1 < len(nums) else float('-inf')
                if nums[i] > prev_value and nums[i] > next_value:
                    return i
                    break