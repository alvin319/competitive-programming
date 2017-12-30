class Solution:
    def findRelativeRanks(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        s = sorted(nums)
        d = {}
        index = 1
        for i in range(len(s) - 1, -1, -1):
            if index == 1:
                d[s[i]] = 'Gold Medal'
            elif index == 2:
                d[s[i]] = 'Silver Medal'
            elif index == 3:
                d[s[i]] = 'Bronze Medal'
            else:
                d[s[i]] = str(index)
            index += 1
        return [d[x] for x in nums]
