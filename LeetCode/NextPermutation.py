class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        valid = False
        current_index = -1
        previous_index = -2
        for i in range(len(nums) - 1, 0, -1):
            if nums[i] > nums[i - 1]:
                valid = True
                current_index = i
                previous_index = i - 1
                break
        if valid:
            swap_num_index = len(nums) - 1
            for i in range(len(nums) - 1, i - 1, -1):
                if nums[i] > nums[previous_index]:
                    swap_num_index = i
                    break
            nums[swap_num_index], nums[previous_index] = nums[previous_index], nums[swap_num_index]
            self.swap_list(nums, current_index, len(nums) - 1)
        else:
            nums.sort()
    
    def swap_list(self, nums, start_index, end_index):
        while start_index < end_index:
            nums[start_index], nums[end_index] = nums[end_index], nums[start_index]
            start_index += 1
            end_index -= 1