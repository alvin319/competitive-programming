class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        ans = []
        
        for _ in range(num + 1):
            ans.append(bin(_).count('1'))
        
        return ans
