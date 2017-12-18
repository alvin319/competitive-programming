class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        current = 0
        for i, v in enumerate(nums):
            if current >= len(nums) - 1:
                return True
            if v == 0 and current < len(nums) - 1 and current <= i:
                return False
            current = max(current, i + v)
        return False
