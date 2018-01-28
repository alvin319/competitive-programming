class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        index = 0
        count = 0
        for v in nums:
            if v == val:
                count += 1
        last_index = len(nums) - 1
        while index < len(nums) - count:
            while nums[index] == val:
                temp = nums[index]
                nums[index] = nums[last_index]
                nums[last_index] = temp
                last_index -= 1
            index += 1
        
        return len(nums) - count