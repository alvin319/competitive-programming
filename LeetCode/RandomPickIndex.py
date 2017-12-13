import random

class Solution(object):

    def __init__(self, nums):
        """
        
        :type nums: List[int]
        :type numsSize: int
        """
        self.d = nums
    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        answer = []
        for i, v in enumerate(self.d):
            if v == target:
                answer.append(i)
        return random.choice(answer)
        


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)