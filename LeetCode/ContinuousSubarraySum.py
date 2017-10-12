class Solution(object):
    def checkSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        k = abs(k)
        total = 0
        
        for v in nums:
            total += v
        
        if k == 1 and total > 0 and len(nums) > 1:
            return True
        
        possible = [0]
        if k != 0:
            for i in range(1, int(round(float(total) / k)) + 1):
                possible.append(i * k)
        
        for target in possible:
            start_index = 0
            total = 0
            end_index = 0
            
            for i, v in enumerate(nums):
                if total == target and (end_index - start_index) + 1 >= 2:
                    return True
                total += v
                end_index = i
                
                if total == target and (end_index - start_index) + 1 >= 2:
                    return True
                elif total > target:
                    total -= nums[start_index]
                    start_index += 1
            
            if total == target and (end_index - start_index) + 1 >= 2:
                return True
        return False
        