class Solution(object):
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i in range(len(nums)):
            while nums[i] != (i + 1) and nums[nums[i] - 1] != nums[i]:
                value = nums[i] - 1
                nums[i], nums[value] = nums[value], nums[i]
        
        answer = []
        for i in range(len(nums)):
            if i != nums[i] - 1:
                answer.append(nums[i])
        return answer