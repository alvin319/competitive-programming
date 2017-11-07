class Solution(object):
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        m = 0
        current_num = 0
        current_m = 0
        
        for i, c in enumerate(nums):
            if i == 0:
                current_num = c
                current_m = 1
                m = max(m, current_m)
            else:
                if c > current_num:
                    current_m += 1
                else:
                    current_m = 1
                m = max(m, current_m)
                current_num = c
        
        return m