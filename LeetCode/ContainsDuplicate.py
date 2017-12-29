class Solution:
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        s = set()
        for x in nums:
            s.add(x)
        return len(s) != len(nums)
