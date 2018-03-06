class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        s = set(nums)
        ans = []
        for i in range(1, len(nums) + 1):
            if i not in s:
                ans.append(i)
        
        return ans
