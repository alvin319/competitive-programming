import numpy as np

class Solution:
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        try:
            mat = np.array(nums)
            new_mat = list(mat.reshape(r, c))
            ans = []
            
            for l in new_mat:
                y = []
                for x in list(l):
                    y.append(int(x))
                ans.append(y)

            return ans
        except:
            return nums
