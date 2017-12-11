final_answer = None

class Solution(object):
    def helper(self, nums, start, end):
        global final_answer
        if start < end:
            mid = (start + end) / 2
            left = None
            right = None
            current = nums[mid]
            if mid - 1 >= 0:
                left = nums[mid - 1]
            if mid + 1 < len(nums):
                right = nums[mid + 1]
            if left is not None and right is not None and left != current and left != right and right != current:
                final_answer = current
                return
            elif left is None and right is not None and current != right:
                final_answer = current
                return
            elif right is None and left is not None and current != left:
                final_answer = current
                return
            self.helper(nums, start, mid)
            self.helper(nums, mid + 1, end)
    
    def singleNonDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        global final_answer
        self.helper(nums, 0, len(nums))
        return final_answer
