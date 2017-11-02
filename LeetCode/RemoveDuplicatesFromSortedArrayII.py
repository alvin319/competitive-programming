class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        index = 0
        
        for i, x in enumerate(nums):
            if index < 2 or x > nums[index - 2]:
                nums[index] = x
                index += 1
                
        return index
        