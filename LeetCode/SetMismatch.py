class Solution:
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        nums = sorted(nums)
        prev = None
        ans = []
        
        for v in nums:
            if prev is None:
                prev = v
            elif v == prev:
                ans.append(prev)
                break
            prev = v
        
        total = (len(nums) * (len(nums) + 1)) / 2
        total -= sum(nums)
        ans.append(int(total + ans[0]))
        
        return ans